package com.epam.controller;

import com.epam.dto.InvoiceData;
import com.epam.model.Cart;
import com.epam.model.OrderDetails;
import com.epam.model.Orders;
import com.epam.service.CartService;
import com.epam.service.OrderDetailsService;
import com.epam.service.OrderService;
import com.epam.uitl.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    CartService CartService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailsService orderDetailsService;

    @RequestMapping(value = "/checkOutOrders", method = RequestMethod.GET)
    public String checkOrder() {

        int amount = 0;
        List<Cart> cartList = CartService.findAll();
        if (cartList != null) {
            for (Cart cart : cartList) {
                amount += cart.getQuanity() * cart.getProduct().getPrice();
            }
        }
        Orders orders = orderService.saveOrder(new Orders(amount));

        if (cartList != null && orders!=null) {
            for (Cart cart : cartList) {
                orderDetailsService.saveOrderDetails(new OrderDetails(orders, cart.getProduct(), cart.getQuanity(), cart.getProduct().getPrice(), cart.getQuanity() * cart.getProduct().getPrice()));
            }
        }
        return "redirect:pdfreport";
    }


    /*@RequestMapping(value = "/getOrderDetails",method = RequestMethod.GET,produces={"application/json"})
    public   @ResponseBody List<InvoiceData> getOrderDetails(){
        List<OrderDetails> listOrderDetails=orderDetailsService.getOrderDetails();
        //String productName, double price, int quantity, double amount
        List<InvoiceData> invoiceData=new ArrayList<>();
        for( OrderDetails od : listOrderDetails){
            invoiceData .add(new InvoiceData(od.getProduct().getName(),od.getProduct().getPrice(),od.getQuanity(),od.getAmount()));
        }
        return  invoiceData;
    }*/


    public List<InvoiceData> getInvoiceData(){

        List<OrderDetails> listOrderDetails=orderDetailsService.getOrderDetails();
        //String productName, double price, int quantity, double amount
        List<InvoiceData> invoiceData=new ArrayList<>();
        for( OrderDetails od : listOrderDetails){
            invoiceData .add(new InvoiceData(od.getProduct().getName(),od.getProduct().getPrice(),od.getQuanity(),od.getAmount()));
        }
        return  invoiceData;
    }


    @RequestMapping(value = "pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> OrderReport() throws IOException {



        ByteArrayInputStream bis = GeneratePdfReport.orderReport(getInvoiceData());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=OrderReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}

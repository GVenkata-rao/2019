package com.epam.controller;

import java.util.Optional;

import com.epam.model.Cart;
import com.epam.model.Product;
import com.epam.model.User;
import com.epam.service.CartService;
import com.epam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("cart", cartService.findAll());
        return "cart/index";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String addCart(@PathVariable("id") Integer id, HttpSession httpSession) {
        Product product = productService.findById(id);
        Optional<Cart> cart = cartService.findByProduct(product.getId());
        if (cart.isPresent()) {
            cart.get().setQuanity(cart.get().getQuanity() + 1);
            cartService.saveCart(cart.get());
        } else {
            User u=(User)httpSession.getAttribute("user");
            Cart cart2 = new Cart();
            cart2.setProduct(product);
            cart2.setQuanity(1);
            cart2.setUser(u);

            cartService.saveCart(cart2);
        }

        return "redirect:/cart/index";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String removeItemFrmCart(@PathVariable("id") Integer id) {
        cartService.deleteCartItem(id);
        return "redirect:/cart/index";
    }

}
package com.epam.dto;

public class InvoiceData {

    private String productName;
    private double price;
    private int quantity;
    private double amount;

    public InvoiceData(){

    }

    public InvoiceData(String productName, double price, int quantity, double amount) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

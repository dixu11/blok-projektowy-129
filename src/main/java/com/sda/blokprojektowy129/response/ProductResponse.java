package com.sda.blokprojektowy129.response;

public class ProductResponse {
    private String name;
    private double price;

    public ProductResponse(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

package com.sda.blokprojektowy129.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    private String name;
    private double price;
    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MultipartFile getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

package com.sda.blokprojektowy129.response;

public class ProductResponse {
    private String name;
    private double price;
    private String fileName; //dodaliśmy nazwę pliku (bez pełnej ścieżki)

    public ProductResponse(String name, double price, String fileName) {
        this.name = name;
        this.price = price;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFileName() {
        return fileName;
    }
}

package com.sda.blokprojektowy129.mode;

import jakarta.persistence.*;

@Entity
@Table(name = "products") //ustawia nazwę tabeli
public class Product {
    @Id //wskazuje klucz główny
    @GeneratedValue(strategy = GenerationType.IDENTITY) //standardowa inkrementacja
    private long id;
    private String name;
    private double price;
    private String fileName;

    //konstruktor dla Hibernate
    public Product() {
    }

    public Product(String name, double price, String fileName) {
        this.name = name;
        this.price = price;
        this.fileName = fileName;
    }

    public String getFileNameWithId() {
        return id + "-"+fileName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

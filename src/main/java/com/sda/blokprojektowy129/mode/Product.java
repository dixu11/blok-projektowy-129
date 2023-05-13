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

    //konstruktor dla Hibernate
    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

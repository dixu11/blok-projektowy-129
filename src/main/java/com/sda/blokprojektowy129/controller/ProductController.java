package com.sda.blokprojektowy129.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {


    @GetMapping("/")
    public String getHomePage() {
        return "index.html";
    }

   // @RequestMapping(path = "/product/add", method = RequestMethod.GET)
    @GetMapping("/product/add")
    public String getPage() {
        return "add-product.html"; //.html można pominąć
    }

    @PostMapping("/product/add")
    public String addProduct(String name, double price) {
        System.out.println(name);
        System.out.println(price);
        System.out.println("dodaję produkt");
        return "index.html";
    }


}

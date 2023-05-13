package com.sda.blokprojektowy129.controller;

import com.sda.blokprojektowy129.request.ProductRequest;
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

    //spring wyłapuje że dane mają identyfikatory: name + price
    //może nam je podstawić do zmiennych name + price
    //lub do obiektu który ma takie pola
    // (private String name, private String price)
    @PostMapping("/product/add")
    public String addProduct(ProductRequest productRequest) {
        return "index.html";
    }


}

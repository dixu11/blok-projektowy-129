package com.sda.blokprojektowy129.controller;

import com.sda.blokprojektowy129.request.ProductRequest;
import com.sda.blokprojektowy129.response.ProductResponse;
import com.sda.blokprojektowy129.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {

private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
        productService.addProduct(productRequest);
        return "index.html";
    }

    @GetMapping("/product/all")
    public String getAllProductsPage(Model model) {
        List<ProductResponse> products = productService.getProducts();
        model.addAttribute("products", products); // wysyłam dane na template
        return "all-products.html";
    }





}

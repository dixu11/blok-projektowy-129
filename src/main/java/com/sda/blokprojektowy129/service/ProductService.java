package com.sda.blokprojektowy129.service;

import com.sda.blokprojektowy129.mode.Product;
import com.sda.blokprojektowy129.repository.ProductRepository;
import com.sda.blokprojektowy129.request.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor - mogłoby zastąpić konstruktor
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequest request) {
        //validacja
        Product product = new Product(request.getName(), request.getPrice());
        productRepository.save(product);
    }

}

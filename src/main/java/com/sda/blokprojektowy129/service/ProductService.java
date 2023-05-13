package com.sda.blokprojektowy129.service;

import com.sda.blokprojektowy129.mode.Product;
import com.sda.blokprojektowy129.repository.ProductRepository;
import com.sda.blokprojektowy129.request.ProductRequest;
import com.sda.blokprojektowy129.response.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
//@AllArgsConstructor - mogłoby zastąpić konstruktor
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    private Environment environment;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequest request) {
        MultipartFile file = request.getFile();
        System.out.println(request.getFile().getName());
        System.out.println(request.getFile().getContentType());
        System.out.println(request.getFile().getSize());
        System.out.println(request.getFile().getOriginalFilename());

        if (file.isEmpty()) {
            throw new IllegalArgumentException("Nie podano pliku!");
        }

        try {
            String uploadDirectory = environment.getProperty("spring.servlet.multipart.location");
            System.out.println(file.getOriginalFilename());
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            System.out.println(fileName);
            File destinationFile = new File(uploadDirectory + File.separator + fileName);
            file.transferTo(destinationFile);
        } catch (IOException e) {
            // Obsługa błędu zapisu pliku
            e.printStackTrace();
        }


        //validacja
        Product product = new Product(request.getName(), request.getPrice());
        productRepository.save(product);
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getName(), product.getPrice()))
                .toList();
    }

}

package com.sda.blokprojektowy129.service;

import com.sda.blokprojektowy129.mode.Product;
import com.sda.blokprojektowy129.repository.ProductRepository;
import com.sda.blokprojektowy129.request.ProductRequest;
import com.sda.blokprojektowy129.response.ProductResponse;
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
       //validacja


        try {
            MultipartFile file = request.getFile();

            if (file.isEmpty()) {
                throw new IllegalArgumentException("Nie podano pliku!");
            }

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            Product product = new Product(request.getName(), request.getPrice(), fileName);
            productRepository.save(product); // nadaje ID!


            String userPath = System.getProperty("user.dir"); // daje lokalizacje projekty
            File destinationFile = new File(userPath + "\\upload" + File.separator + product.getFileNameWithId());
            file.transferTo(destinationFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getName(), product.getPrice()))
                .toList();
    }

}

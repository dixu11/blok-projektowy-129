package com.sda.blokprojektowy129.controller;

import com.sda.blokprojektowy129.service.ProductService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;

@RestController
public class ImageController {

    //regex potrzebny bo PathVariable gubi się przy kropce
    @GetMapping("/images/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        //zwracamy jako Resource aby Spring wiedział jak skonstruować odpowiedź
        try {
            File file = new File(ProductService.UPLOAD_LOCATION + fileName);
            if (!file.exists() || !file.isFile()) { // kontrola poprawności lokalizacji
                //return error
                return ResponseEntity.notFound()
                        .build();
            }
            Resource resource = new UrlResource(file.toURI());
            //tłumaczenie ze ścieżki na URI: dodaje przedrostek 'file'
            return ResponseEntity.ok(resource);
        } catch (MalformedURLException e) {
            //return error
            return ResponseEntity.badRequest()
                    .build();
        }
    }
}

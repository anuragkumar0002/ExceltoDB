package com.exceltodb.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exceltodb.entity.Product;
import com.exceltodb.helper.ExcelHelper;
import com.exceltodb.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@CrossOrigin("*")
public class MainController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload") 
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        if(ExcelHelper.checkExcelFormat(file)){
            this.productService.save(file);
            return ResponseEntity.ok(Map.of("message", "file is uploaded and data is saved to db"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel Sheet");
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return this.productService.getAllProducts();
    }

}



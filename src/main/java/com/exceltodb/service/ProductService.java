package com.exceltodb.service;

import java.io.IOException;
import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exceltodb.entity.Product;
import com.exceltodb.helper.ExcelHelper;
import com.exceltodb.repo.ProducteRepo;

@Service
public class ProductService {

    @Autowired
    private ProducteRepo productRepo;

    public void save(MultipartFile file) {
        List<Product> products;
        try {
            products = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
            this.productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    
}

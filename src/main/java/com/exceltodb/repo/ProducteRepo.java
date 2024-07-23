package com.exceltodb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exceltodb.entity.Product;

public interface ProducteRepo extends JpaRepository<Product, Integer> {
    
}

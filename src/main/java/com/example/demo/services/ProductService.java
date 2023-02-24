package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Products creer(Products products, long id);
    Optional<Products> findById(Long id);
    /*Optional<Products> findById(Categories categories);*/
    List<Products> findAll();
    Products modifier(Long id,Products products);
    String supprimer (Long id);
}

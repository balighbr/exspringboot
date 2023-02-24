package com.example.demo.repositories;

import com.example.demo.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository <Products, Long> {
}

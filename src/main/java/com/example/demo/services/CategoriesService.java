package com.example.demo.services;

import com.example.demo.entities.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    Categories creer(Categories categories);
    Optional<Categories> lire(Long id);

    List<Categories> findAll();

    Categories modifier(Long id, Categories categories);
    String supprimer (Long id);
}

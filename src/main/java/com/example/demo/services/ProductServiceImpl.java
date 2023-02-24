package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Products;
import com.example.demo.repositories.ProductsRepository;
import com.example.demo.repositories.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    @Override
    public String supprimer(Long id) {
        productsRepository.deleteById(id);
        return"Supprimé";
    }

    @Override
    public Products creer (Products products, long id) {
        products.getCategorie();

        Categories categorie = categoriesRepository.findById(id).orElse(null);
        products.setCategorie(categorie);
        products.setDateCreationProd(new Timestamp(System.currentTimeMillis()));


        return productsRepository.save(products);
    }
    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    /*@Override
    public Optional<Products> findById(Categories categories) {
        return productsRepository.findById(categories);
    }*/

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }


    public Optional<Products> lire(Long id) {
        return productsRepository.findById(id);

    }

    @Override
    public Products modifier(Long id, Products products) {
        Products existingCategorie = productsRepository.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setNomp(products.getNomp());
            existingCategorie.setQtp(products.getQtp());
            existingCategorie.setDateModif(new Timestamp(System.currentTimeMillis()));
            existingCategorie.setCategorie(products.getCategorie());

            return productsRepository.save(existingCategorie);
        }
        return null;

    }






}

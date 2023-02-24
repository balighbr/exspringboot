//package com.example.demo.services;
//import com.example.demo.entities.Categories;
//import com.example.demo.entities.Products;
//import com.example.demo.repositories.CategoriesRepository;
//import jakarta.persistence.Id;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.yaml.snakeyaml.events.Event;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//
//
//class ProduitServiceTest {
//    @Autowired
//    private ProductService produitService;
//    @Autowired
//    private CategoriesService categoriesService ;
//
//
//    @Test
//    public void SaveProduitSucces(){
//        Categories categories = new Categories();
//        Categories savedCategorie = categoriesService.creer(categories);
//        Products expectedProduit = Products.builder()
//                .Nom("name prod")
//                .Qt(1L)
//                .Disponible(true)
//                .categorie(savedCategorie)
//                .build();
//        Products savedProduit = produitService.creer(expectedProduit);
//        assertNotNull(savedProduit);
//        assertNotNull(savedProduit.getId());
//        assertNotNull(expectedProduit.getQt() , String.valueOf(savedProduit.getQt()));
//        assertNotNull(expectedProduit.getNom() , savedProduit.getNom());
//
//
//    }
//
//    @Test
//    public void UpdateProduitSucces(){
//        Categories category;
//        category = CategoriesRepository.findB(10L).orElse(null);
//        assertNotNull(category);
//        Products produit = Products.findById(14L).orElse(null);
//        assertNotNull(produit);
//        produit.setNom("test test test");
//        produit.setDisponible(true);
//        produit.setCategorie(category);
//        produit.setQt(140L);
//        Products savedProd=produitService.creer(produit);
//
//        Products upadateProduit = savedProd;
//        savedProd = produitService.modifier(savedProd.getId(), upadateProduit);
//
//
//        assertNotNull(upadateProduit);
//        assertNotNull(upadateProduit.getId());
//        assertNotNull(upadateProduit.getQt() , String.valueOf(savedProd.getQt()));
//        assertNotNull(upadateProduit.getNom() , savedProd.getNom());
//    }
//    @Test
//    public void DeleteProduitSucces(){
//        Categories categories = new Categories();
//        Products produit = new Products();
//        Categories savedCategorie = categoriesService.creer(categories);
//        Products expectedProduit = Products.builder()
//                .id(12L)
//                .Nom("name prod")
//                .Qt(1L)
//                .Disponible(true)
//                .categorie(savedCategorie)
//                .build();
//        Products savedProd=produitService.creer(expectedProduit);
//
//        boolean isDelted= produitService.supprimer(Math.toIntExact(savedProd.getId()));
//        assertTrue(isDelted);
//        Optional<Products> optionalProduit= Pr.findById(savedProd.getId());
//        assertFalse(optionalProduit.isPresent());
//    }
//
//}

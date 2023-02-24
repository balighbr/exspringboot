package com.example.demo.controller;

import com.example.demo.entities.Products;
import com.example.demo.services.ProductService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Builder
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/products")
public class ProductsController {private static ProductService productService;
    @Autowired
    public  void productsControlleur(ProductService produitService) {
        this.productService = produitService;
    }

    @PostMapping("/add/{id}")
    public Products ajout(@RequestBody Products produit,@PathVariable long id) {
        return productService.creer(produit,id);
    }
    @GetMapping("/get/{id}")
    public Optional<Products> findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable("id") Long id)
    {
        productService.supprimer(id);
        return "supprimé";
    }
    @GetMapping("/geta")
    public List<Products> findAll() {

        return productService.findAll();
    }

    @PutMapping("modif/{id}")
    public Products update(@PathVariable Long id, @RequestBody Products products){
        return productService.modifier(id,products);
    }}
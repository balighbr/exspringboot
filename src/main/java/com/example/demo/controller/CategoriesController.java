package com.example.demo.controller;

import com.example.demo.entities.Categories;
import com.example.demo.services.CategoriesService;
import lombok.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Builder
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping("lire/{id}")
    public Optional<Categories> findById(@PathVariable("id") Long id) {

        return categoriesService.lire(id);
    }
    @GetMapping("/getall")
    public List<Categories> findAll() {

        return categoriesService.findAll();
    }
    @PostMapping("/add")
    public Categories creer(@RequestBody Categories c) {
        return categoriesService.creer(c);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable("id") Long id) {
        categoriesService.supprimer(id);
        return "supprimé";
    }
    @PutMapping("/modifier/{id}")
    public Categories modifier(@PathVariable("id") Long id , @RequestBody Categories c) {
        return categoriesService.modifier(id,c);
    }

}

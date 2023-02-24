package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.repositories.CategoriesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class CategoriesServiceImplTest {
    @Autowired
    private CategoriesService service;
    @Autowired
    public CategoriesRepository categorieRepository;
    @Test
    public void testAddCategorie() throws ParseException {
        Categories categorie = new Categories();
        categorie.setNom("Test1");
        categorie.setQt(110L);
//        categorie.setDateCeation(Timestamp.from());
        Categories savedCategorie = service.creer(categorie);
        Assertions.assertNotNull(savedCategorie);
        Assertions.assertEquals(savedCategorie.getNom(),"Test1");
        Assertions.assertEquals(savedCategorie.getQt(),110L);
    }

    @Test
    public void testUpdateCategorie() {
        Categories categorie = new Categories();
        categorie.setNom("baligh");
        categorie.setQt(50L);
        Categories savedCategorie = service.creer(categorie);
        Assertions.assertNotNull(savedCategorie);
        Assertions.assertEquals(savedCategorie.getNom(),"baligh");
        Assertions.assertEquals(savedCategorie.getQt(),50L);
        Categories updatedCategorie = new Categories();

        updatedCategorie.setNom("Test Category Updated");
        updatedCategorie.setQt(10L);

        Categories modifiedCategorie = service.modifier(savedCategorie.getId(), updatedCategorie);
        Assertions.assertNotNull(modifiedCategorie.getId());
        Assertions.assertEquals(modifiedCategorie.getNom(),"Test Category Updated");
        Assertions.assertEquals(modifiedCategorie.getQt(),10L);

    }


    @Test
    public void testDeleteCategorie()  {
        Categories categorie = new Categories();
        categorie.setNom("Baligh2");
        Categories savedCategorie = service.creer(categorie);
        Assertions.assertNotNull(savedCategorie);
        Assertions.assertEquals(savedCategorie.getNom(),"Baligh2");




    }

//
//    @Test
//    public void FindAllSucces() {
//        List<Categories> foundCategorie = service.findAll();
//        assertNotNull(foundCategorie);
//
//    }
//    @Test
//    public void testFindCategorieById() {
//
//        Categories categorie = new Categories();
//        categorie.setNom("Test Category");
//        categorie.setQt(5L);
//        Categories savedCategorie = service.creer(categorie);
//        Optional<Categories> foundCategorie = service.findById(savedCategorie.getId());
//        assertThat(foundCategorie).isNotNull();
//
//    }

}
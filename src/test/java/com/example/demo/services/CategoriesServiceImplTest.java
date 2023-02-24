package com.example.demo.services;

import com.example.demo.entities.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class CategoriesServiceImplTest {

    @Autowired
    private CategoriesService categoriesService;
@Test
    public void shouldsavecategorywithsucces() {
        Categories expectedCategorie = Categories.builder()
                .id(3L)
                .qt(78L)
                .Nom("lok")
                .build();
        Categories categorieAjoue = categoriesService.creer(expectedCategorie);
        Assertions.assertNotNull(categorieAjoue);
        Assertions.assertNotNull(categorieAjoue.getId());
        Assertions.assertEquals(expectedCategorie.getQt(),categorieAjoue.getQt());
        Assertions.assertEquals(expectedCategorie.getId(),categorieAjoue.getId());
        Assertions.assertEquals(expectedCategorie.getNom(),categorieAjoue.getNom());

    }
     @Test
   public void shouldupdatecategorywithsuccec() {
        Categories expectedCategorie = Categories.builder()
                .id(3L)
                .qt(50L)
                .Nom("test")
                .build();
        Categories categorieAjoue = categoriesService.creer(expectedCategorie);
        Categories categorieToUpdate =categorieAjoue;
        categorieToUpdate.setId(2L);
        categorieToUpdate.setNom("JJ");
        categorieToUpdate.setQt(65L);

        Assertions.assertNotNull(categorieToUpdate);
        Assertions.assertNotNull(categorieToUpdate.getId());
        Assertions.assertEquals(categorieToUpdate.getQt(),categorieAjoue.getQt());
        Assertions.assertEquals(categorieToUpdate.getId(),categorieAjoue.getId());
        Assertions.assertEquals(categorieToUpdate.getNom(),categorieAjoue.getNom());

    }
   @Test
    public void shoulddeletecategorywithsuccec() {
        Categories expectedCategorie = Categories.builder()
                .id(3L)

                .build();
        Categories categorieAjoue = categoriesService.creer(expectedCategorie);


        boolean isDeleted = Boolean.parseBoolean(categoriesService.supprimer(categorieAjoue.getId()));
        Assertions.assertFalse(isDeleted);
        Optional<Categories> categorie=categoriesService.lire(categorieAjoue.getId());
        assertFalse(categorie.isPresent());




    }


}



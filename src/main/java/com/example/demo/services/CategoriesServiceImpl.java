package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.repositories.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;



    @Override
    public Categories creer(Categories categories) {
        categories.setDateCeation(new Timestamp(System.currentTimeMillis()));
        return categoriesRepository.save(categories);

    }

    @Override
    public Optional<Categories> lire(Long id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories modifier(Long id, Categories categories)  {
        Categories existingCategorie = categoriesRepository.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setNom(categories.getNom());
            existingCategorie.setQt(categories.getQt());
            existingCategorie.setDateModif(new Timestamp(System.currentTimeMillis()));
            return categoriesRepository.save(existingCategorie);
        }
        return null;
    }

    @Override
    public String supprimer(Long id) {
        categoriesRepository.deleteById(id);
        return "supprimé";
    }
}

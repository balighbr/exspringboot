package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
@Builder
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "nom")
    private String nom;
    @Column(name = "Qt")
    private Long qt;
    @Column(name = "date_creation")
    private Timestamp dateCeation;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Products> p;

}

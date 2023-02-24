package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JsonBackReference
    @ManyToOne
    Categories categorie;
    @Column(name = "nomprod")
    private String nomp;
    @Column(name = "Qtprod")
    private Long qtp;
    @Column(name = "Disponible")
    private boolean disponible;
    @Column(name = "date_creation_prod")
    private Timestamp dateCreationProd;
    @Column(name = "date_modif_prod")
    private Timestamp dateModif;



}

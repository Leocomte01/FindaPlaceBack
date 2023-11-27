package com.example.Findaplace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "tags")
@NoArgsConstructor
@Getter
@Setter
public class Tags {

    // Identifiant du tag, généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du tag
    @Column(length = 1000)
    private String name;

    // Couleur associée au tag
    @Column
    private String color;

    // Relation Many-to-Many avec la classe Review
    // Chaque Review peut avoir plusieurs tags et chaque tag peut être associé à plusieurs reviews
    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();
}

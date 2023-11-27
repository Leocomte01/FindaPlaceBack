package com.example.Findaplace.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "review")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Review {

    // Identifiant de la critique, généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Commentaire de la critique avec une longueur maximale de 3000 caractères
    @Column(length = 3000)
    private String comment;

    // Note attribuée à la critique
    @Column
    private int rate;

    // Date de publication de la critique
    @Column
    private Date date_publication;

    // Relation Many-to-One avec la classe Users, FetchType.EAGER indique un chargement immédiat
    // Plusieurs critiques peuvent être faites par un même utilisateur
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private Users users;

    // Relation Many-to-One avec la classe Place, FetchType.EAGER indique un chargement immédiat
    // Plusieurs peuvent recevoir des critiques
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;

    // Relation Many-to-Many avec la classe Tags
    // Chaque critique peut avoir plusieurs tags et chaque tag peut être associé à plusieurs critiques
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "review_tag",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tags> tags = new HashSet<>();

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", rate=" + rate +
                ", date_publication=" + date_publication +
                ", users=" + users +
                ", place=" + place +
                '}';
    }
}

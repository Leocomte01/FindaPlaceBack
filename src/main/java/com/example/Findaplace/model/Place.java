package com.example.Findaplace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "place")
@NoArgsConstructor
@Getter
@Setter
public class Place {

    // Identifiant du lieu, généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation One-to-Many avec la classe Review, mappedBy indique le champ dans la classe Review
    // Un lieu peut recevoir plusieurs critiques
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> review;

    // Identifiant unique du lieu dans Google
    @Column(unique = true)
    private String id_place_google;

    // Nom du lieu
    @Column
    private String name;

    // Adresse du lieu
    @Column
    private String address;

    // Emplacement géographique du lieu
    @Column
    private String location;

    // Images associées au lieu
    @Column
    private String images;

    // Icône associée au lieu
    @Column
    private String icon;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", review=" + review +
                ", id_place_google='" + id_place_google + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", images='" + images + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

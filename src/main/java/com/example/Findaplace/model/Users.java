package com.example.Findaplace.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "users")
@NoArgsConstructor
@Getter
@Setter
public class Users {
    // Identifiant de l'utilisateur, généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom d'utilisateur
    private String user_name;

    // Nom de famille de l'utilisateur
    @Column(length = 100)
    private String last_name;

    // Prénom de l'utilisateur
    @Column(length = 100)
    private String first_name;

    // Mot de passe de l'utilisateur
    @Column(length = 100)
    private String password;

    // Adresse e-mail de l'utilisateur
    @Column(length = 100)
    private String email;

    // Relation One-to-Many avec la classe Review, mappedBy indique le champ dans la classe Review
    // Une review ne peut être faite que par un utilisateur
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    // Relation One-to-Many avec la classe FollowingRelation en tant que suiveur
    // On peut suivre plusieurs personnes
    @OneToMany(mappedBy = "follower")
    @JsonIgnore
    private List<FollowingRelation> followingRelations;

    // Relation One-to-Many avec la classe FollowingRelation en tant que suivi
    // On peut être suivi.e par plusieurs personnes
    @OneToMany(mappedBy = "following")
    @JsonIgnore
    private List<FollowingRelation> followerRelations;
}

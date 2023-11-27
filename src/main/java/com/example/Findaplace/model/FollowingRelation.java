package com.example.Findaplace.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Entity
@Table(name= "following_relation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EnableTransactionManagement
public class FollowingRelation {

    // Identifiant de la relation de suivi, généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation Many-to-One avec la classe Users en tant que suiveur
    @ManyToOne()
    @JoinColumn(name = "follower_id")
    private Users follower;

    // Relation Many-to-One avec la classe Users en tant que suivi
    @ManyToOne()
    @JoinColumn(name = "following_id")
    private Users following;
}

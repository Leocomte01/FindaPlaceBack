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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "follower_id")
    private Users follower;

    @ManyToOne()
    @JoinColumn(name = "following_id")
    private Users following;
}

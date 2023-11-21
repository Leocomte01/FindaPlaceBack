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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3000)
    private String name;

    @Column
    private String color;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();
}

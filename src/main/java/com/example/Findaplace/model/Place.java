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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> review;

    @Column(unique = true)
    private String id_place_google;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String location;

    @Column
    private String images;

    @Column
    private String icon;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", review=" + review +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", images='" + images + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}


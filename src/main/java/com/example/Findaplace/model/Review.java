package com.example.Findaplace.model;


// import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "review")
@NoArgsConstructor
@Getter
@Setter
public class Review {

    // @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3000)
    private String comment;

    @Column
    private int rate;

    @Column
    private Date date_publication;

    @Column(length = 1000)
    private String id_place_google;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}
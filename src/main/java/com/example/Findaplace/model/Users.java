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

    // @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_name;

    // @ApiModelProperty(required = true)
    @Column(length = 100)
    private String last_name;

    // @ApiModelProperty(required = true)
    @Column(length = 100)
    private String first_name;

    // @ApiModelProperty(required = true)
    @Column(length = 100)
    private String password;

    // @ApiModelProperty(required = true)
    @Column(length = 100)
    private String email;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "follower")
    @JsonIgnore
    private List<FollowingRelation> followingRelations;

    @OneToMany(mappedBy = "following")
    @JsonIgnore
    private List<FollowingRelation> followerRelations;
}

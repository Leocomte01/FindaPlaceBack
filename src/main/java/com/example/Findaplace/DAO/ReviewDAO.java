package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r " +
            "JOIN r.users u " +
            "WHERE u.id =:id")
    Users findAllByUserId(Long id);

}

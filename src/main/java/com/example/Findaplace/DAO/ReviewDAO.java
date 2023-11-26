package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r " +
            "JOIN r.users u " +
            "WHERE u.id =:id")
    List<Review> findAllByUserId(Long id);

    @Query("SELECT r FROM Review r " +
            "JOIN r.place p " +
            "WHERE p.id =:id")
    List<Review> findAllByPlaceId(Long id);

    @Query("SELECT r FROM Review r " +
            "WHERE r.place.id =:placeId " +
            "AND r.users.id =:userId")
    Optional<Review> findReviewForPlaceAndUser(Long placeId, Long userId);

}

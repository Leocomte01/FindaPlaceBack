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

    // Requête pour récupérer la liste des critiques associées à un utilisateur spécifié par son ID
    @Query("SELECT r FROM Review r " +
            "JOIN r.users u " +
            "WHERE u.id = :id")
    List<Review> findAllByUserId(Long id);

    // Requête pour récupérer la liste des critiques associées à un lieu spécifié par son ID
    @Query("SELECT r FROM Review r " +
            "JOIN r.place p " +
            "WHERE p.id = :id")
    List<Review> findAllByPlaceId(Long id);

    // Requête pour récupérer une critique unique associée à un lieu et un utilisateur spécifiés par leurs ID
    @Query("SELECT r FROM Review r " +
            "WHERE r.place.id = :placeId " +
            "AND r.users.id = :userId")
    Optional<Review> findReviewForPlaceAndUser(Long placeId, Long userId);
}

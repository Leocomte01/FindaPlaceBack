package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Long> {

    // Requête pour récupérer la liste des tags associés à une critique spécifiée par son ID
    @Query("SELECT t FROM Tags t " +
            "JOIN t.reviews r " +
            "WHERE r.id =:id")
    List<Tags> findByReviewId(Long id);
}

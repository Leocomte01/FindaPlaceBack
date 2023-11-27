package com.example.Findaplace.service;

import com.example.Findaplace.DAO.ReviewDAO;
import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewDAO reviewDAO;
    private final UserDao userDao;

    // Méthode pour récupérer toutes les critiques
    public List<Review> findAll() {
        return reviewDAO.findAll();
    }

    // Méthode pour récupérer les critiques associées à un utilisateur spécifié par son ID
    public List<Review> findAllByUserId(Long id) {
        return reviewDAO.findAllByUserId(id);
    }

    // Méthode pour récupérer les critiques associées à un lieu spécifié par son ID
    public List<Review> findAllByPlaceId(Long id) {
        return reviewDAO.findAllByPlaceId(id);
    }

    // Méthode pour récupérer une critique associée à un lieu et un utilisateur spécifiés par leurs ID
    public Optional<Review> findReviewByPlaceAndUser(Long placeId, Long userId) {
        return reviewDAO.findReviewForPlaceAndUser(placeId, userId);
    }

    // Méthode pour supprimer une critique par son ID
    public void deleteById(Long id) {
        reviewDAO.deleteById(id);
    }

    // Méthode pour mettre à jour une critique par son ID
    public void updateById(Long id) {
        Review review = reviewDAO.findById(id).orElse(null);
    }

    // Méthode pour récupérer les activités des utilisateurs suivis par un utilisateur spécifié par son ID
    public List<Review> getActivities(long id) {
        List<Users> listFollower = userDao.findFollowers(id);
        List<List<Review>> listReviewFromFollowerUser = new ArrayList<>();
        for (Users follower : listFollower) {
            listReviewFromFollowerUser.add(reviewDAO.findAllByUserId(follower.getId()));
        }
        List<Review> activities = new ArrayList<>();
        for (List<Review> sousListe : listReviewFromFollowerUser) {
            activities.addAll(sousListe);
        }
        return activities;
    }

    // Méthode pour récupérer une critique par son ID
    public Optional<Review> findById(Long id) {
        return reviewDAO.findById(id);
    }

    // Méthode pour ajouter une nouvelle critique
    public void addReview(Review review) {
        reviewDAO.save(review);
    }
}

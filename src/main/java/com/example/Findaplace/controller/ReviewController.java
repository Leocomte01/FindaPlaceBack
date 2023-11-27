package com.example.Findaplace.controller;

import com.example.Findaplace.model.Review;
import com.example.Findaplace.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.http11.upgrade.UpgradeProcessorExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    // Endpoint pour récupérer toutes les critiques
    @ResponseBody
    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    // Endpoint pour récupérer toutes les critiques d'un utilisateur par son ID
    @ResponseBody
    @GetMapping("/user/{id}")
    public List<Review> getAllReviewsByUserId(@PathVariable Long id) {
        return reviewService.findAllByUserId(id);
    }

    // Endpoint pour récupérer toutes les critiques d'un lieu par son ID
    @ResponseBody
    @GetMapping("/place/{id}")
    public List<Review> getAllReviewsByPlaceId(@PathVariable Long id) {
        return reviewService.findAllByPlaceId(id);
    }

    // Endpoint pour récupérer une critique spécifique d'un lieu et d'un utilisateur par leurs IDs
    @ResponseBody
    @GetMapping("/place/{placeId}/user/{userId}")
    public Review getReviewForPlaceAndUser(@PathVariable Long placeId, @PathVariable Long userId) {
        Optional<Review> optionalReview = reviewService.findReviewByPlaceAndUser(placeId, userId);
        return optionalReview.orElse(null);
    }

    // Endpoint pour récupérer une critique par son ID
    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    // Endpoint pour récupérer les activités des utilisateurs suivis par un utilisateur spécifié par son ID
    @ResponseBody
    @GetMapping("/activities/{id}")
    public List<Review> getActivities(@PathVariable Long id) {
        return reviewService.getActivities(id);
    }

    // Endpoint pour ajouter une nouvelle critique
    @PostMapping("")
    public ResponseEntity<?> addReview(@RequestBody Review review) {
        try {
            reviewService.addReview(review);
            return ResponseEntity.ok().build(); // Retourne 200 OK pour le succès
        } catch (Exception e) {
            logger.error("Error adding review", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding review: " + e.getMessage());
        }
    }

    // Endpoint pour supprimer une critique par son ID
    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }

    // Endpoint pour mettre à jour une critique par son ID
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable Long id,
                                          @RequestBody Review review) {
        try {
            Optional<Review> optionalReview = reviewService.findById(id);
            if (optionalReview.isPresent()) {
                Review reviewFound = review;
            }
            reviewService.updateById(id);
            return ResponseEntity.ok().build(); // Retourne 200 OK pour le succès
        } catch (Exception e) {
            logger.error("Error updating review", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating review: " + e.getMessage());
        }
    }
}

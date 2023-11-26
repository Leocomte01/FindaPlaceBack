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

    @ResponseBody
    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public List<Review> getAllReviewsByUserId(@PathVariable Long id) {
        return reviewService.findAllByUserId(id);
    }

    @ResponseBody
    @GetMapping("/place/{id}")
    public List<Review> getAllReviewsByPlaceId(@PathVariable Long id) {
        return reviewService.findAllByPlaceId(id);
    }

    @ResponseBody
    @GetMapping("/place/{placeId}/user/{userId}")
    public Review getReviewForPlaceAndUser(@PathVariable Long placeId, @PathVariable Long userId) {
        Optional<Review> optionalReview = reviewService.findReviewByPlaceAndUser(placeId, userId);
        return optionalReview.orElse(null);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    //il faut mettre l'id de l'utilisateur connecté
    @ResponseBody
    @GetMapping("/activities/{id}")
    public List<Review> getActivities(@PathVariable Long id){return reviewService.getActivities(id);}

    @PostMapping("")
    public ResponseEntity<?> addReview(@RequestBody Review review) {
        try {
            reviewService.addReview(review);
            return ResponseEntity.ok().build(); // Return 200 OK for success
        } catch (Exception e) {
            logger.error("Error adding review", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding place: " + e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable Long id,
                                          @RequestBody Review review) {
        try {
            Optional<Review> optionalReview = reviewService.findById(id);
            if (optionalReview.isPresent()) {
                Review reviewFound = review;
            }
            reviewService.updateById(id);
            return ResponseEntity.ok().build(); // Return 200 OK for success
        } catch (Exception e) {
            logger.error("Error updating review", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding place: " + e.getMessage());
        }
    }
}

package com.example.Findaplace.controller;

import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import com.example.Findaplace.service.ReviewService;
import com.example.Findaplace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Review> getAllReviewsByUserId(@PathVariable Long id) {
        return reviewService.findAllByUserId(id);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void updateReview(@PathVariable Long id){ reviewService.updateById(id);}
}

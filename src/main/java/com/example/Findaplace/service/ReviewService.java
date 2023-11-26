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
    public List<Review> findAll(){
        return reviewDAO.findAll();
    }

    public List<Review> findAllByUserId(Long id){
        return reviewDAO.findAllByUserId(id);
    }

    public List<Review> findAllByPlaceId(Long id){
        return reviewDAO.findAllByPlaceId(id);
    }

    public Optional<Review> findReviewByPlaceAndUser(Long placeId, Long userId) {
        return reviewDAO.findReviewForPlaceAndUser(placeId, userId);
    }

    public void deleteById(Long id) { reviewDAO.deleteById(id);}

    public void updateById(Long id){
        Review review = reviewDAO.findById(id).get();
    }

    public List<Review> getActivities(long id){
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

    public Optional<Review> findById(Long id){
        return reviewDAO.findById(id);
    }

    public void addReview(Review review){
        reviewDAO.save(review);
    }
}

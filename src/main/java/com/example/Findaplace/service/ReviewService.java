package com.example.Findaplace.service;

import com.example.Findaplace.DAO.ReviewDAO;
import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewDAO reviewDAO;

    public List<Review> findAll(){
        return reviewDAO.findAll();
    }

    public List<Review> findAllByUserId(Long id){
        return reviewDAO.findAllByUserId(id);
    }

    public void deleteById(Long id) { reviewDAO.deleteById(id);}

    public void updateById(Long id){
        Review review = reviewDAO.findById(id).get();

    }

    public Review getById(Long id){
        return reviewDAO.getById(id);
    }

    public void addReview(Review review){
        reviewDAO.save(review);
    }
}

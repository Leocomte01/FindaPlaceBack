package com.example.Findaplace.service;

import com.example.Findaplace.DAO.FollowingRelationDAO;
import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.FollowingRelation;
import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowingRelationService {

    private final FollowingRelationDAO followingRelationDAO;
    private final UserDao userDao;
    public void addRelation(Long followerId, Long followedId){
        Users follower =  userDao.findById(followerId).get();
        Users followed =  userDao.findById(followedId).get();

        FollowingRelation followingRelation = FollowingRelation.builder()
                .follower(follower)
                .following(followed)
                .build();

        followingRelationDAO.save(followingRelation);
    }
/*
    public FollowingRelation addRelation2(FollowingRelation followingRelation){
        return followingRelationDAO.save(followingRelation);
    }*/

}

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

    // Méthode pour ajouter une relation de suivi entre un follower et un utilisateur suivi
    public void addRelation(Long followerId, Long followedId) {
        Users follower = userDao.findById(followerId).orElse(null);
        Users followed = userDao.findById(followedId).orElse(null);

        // Vérifie si les utilisateurs existent avant de créer la relation de suivi
        if (follower != null && followed != null) {
            FollowingRelation followingRelation = FollowingRelation.builder()
                    .follower(follower)
                    .following(followed)
                    .build();

            followingRelationDAO.save(followingRelation);
        }
    }

    public void deleteRelation(Long followerId, Long followedId){
        Users follower =  userDao.findById(followerId).get();
        Users followed =  userDao.findById(followedId).get();
        followingRelationDAO.deleteByFollowerAndFollowing(follower, followed);
    }

}

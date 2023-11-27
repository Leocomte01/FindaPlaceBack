package com.example.Findaplace.controller;

import com.example.Findaplace.model.FollowingRelation;
import com.example.Findaplace.model.Review;
import com.example.Findaplace.service.FollowingRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/relation")
@RequiredArgsConstructor
public class FollowingRelationController {

    private final FollowingRelationService followingRelationService;

    // Endpoint pour ajouter une relation de suivi entre deux utilisateurs (suivre)
    @ResponseBody
    @PostMapping("")
    public void addRelation(@RequestParam("follower") Long followerId, @RequestParam("followed") Long followedId) {
        followingRelationService.addRelation(followerId, followedId);
    }

    // Endpoint pour supprimer une relation de suivi entre deux utilisateurs (se désabonner)
    @DeleteMapping("")
    public void deleteRelation(@RequestParam("follower") Long followerId, @RequestParam("followed") Long followedId){
        followingRelationService.deleteRelation(followerId, followedId);
    }
}

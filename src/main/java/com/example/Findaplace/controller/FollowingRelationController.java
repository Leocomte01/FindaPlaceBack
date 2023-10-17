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

    @PostMapping("")
            public void addRelation(@RequestParam("follower") Long followerId, @RequestParam("followed") Long followedId){
        followingRelationService.addRelation(followerId, followedId);
    }
}

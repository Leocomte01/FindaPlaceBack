package com.example.Findaplace.controller;

import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Tags;
import com.example.Findaplace.service.ReviewService;
import com.example.Findaplace.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagsController {

    private final TagsService tagsService;

    @GetMapping("")
    public List<Tags> getAllTags() {
        return tagsService.findAll();
    }

    @GetMapping("/review/{id}")
    public List<Tags> getTagsFromReview(@PathVariable Long id){ return tagsService.findByReviewId(id);}
}

package com.example.Findaplace.service;

import com.example.Findaplace.DAO.TagsDAO;
import com.example.Findaplace.model.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagsService {

    private final TagsDAO tagsDao;

    // Méthode pour récupérer tous les tags
    public List<Tags> findAll() {
        return tagsDao.findAll();
    }

    // Méthode pour récupérer les tags associés à une critique spécifiée par son ID
    public List<Tags> findByReviewId(Long id) {
        return tagsDao.findByReviewId(id);
    }
}

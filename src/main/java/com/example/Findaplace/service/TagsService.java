package com.example.Findaplace.service;

import com.example.Findaplace.DAO.TagsDAO;
import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.Tags;
import com.example.Findaplace.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagsService {

    private final TagsDAO tagsDao;

    public List<Tags> findAll(){
        return tagsDao.findAll();
    }

    public List<Tags> findByReviewId(Long id){ return tagsDao.findByReviewId(id);}
}


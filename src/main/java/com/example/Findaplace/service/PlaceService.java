package com.example.Findaplace.service;

import com.example.Findaplace.DAO.PlaceDao;
import com.example.Findaplace.DAO.UserDao;
import com.example.Findaplace.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceDao placeDao;
    private final UserDao userDao;
    public List<Place> findAll(){
        return placeDao.findAll();
    }

    public Place findPlaceByGoogleId(String id){
        return placeDao.findPlaceByGoogleId(id);
    }

    public void deleteById(Long id) { placeDao.deleteById(id);}

    public void updateById(Long id){
        Place place = placeDao.findById(id).get();
    }

    public Optional<Place> findById(Long id){
        return placeDao.findById(id);
    }

    public void addPlace(Place place){
        if (placeDao.findPlaceByGoogleId(place.getId_place_google()) == null) {
            placeDao.save(place);
        }
    }
}

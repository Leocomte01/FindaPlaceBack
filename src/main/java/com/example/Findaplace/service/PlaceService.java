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

    // Méthode pour récupérer tous les lieux
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    // Méthode pour récupérer un lieu par son identifiant Google
    public Place findPlaceByGoogleId(String id) {
        return placeDao.findPlaceByGoogleId(id);
    }

    // Méthode pour supprimer un lieu par son ID
    public void deleteById(Long id) {
        placeDao.deleteById(id);
    }

    // Méthode pour mettre à jour un lieu par son ID
    public void updateById(Long id) {
        Place place = placeDao.findById(id).orElse(null);
    }

    // Méthode pour récupérer un lieu par son ID
    public Optional<Place> findById(Long id) {
        return placeDao.findById(id);
    }

    // Méthode pour ajouter un nouveau lieu (si un lieu avec le même identifiant Google n'existe pas déjà)
    public void addPlace(Place place) {
        if (placeDao.findPlaceByGoogleId(place.getId_place_google()) == null) {
            placeDao.save(place);
        }
    }
}

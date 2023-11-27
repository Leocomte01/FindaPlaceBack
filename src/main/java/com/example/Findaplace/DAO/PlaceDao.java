package com.example.Findaplace.DAO;

import com.example.Findaplace.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceDao  extends JpaRepository<Place, Long> {

    // Requête personnalisée pour récupérer un lieu par son identifiant Google
    @Query("SELECT p FROM Place p " +
            "WHERE p.id_place_google =:google_id")
    Place findPlaceByGoogleId(String google_id);

}

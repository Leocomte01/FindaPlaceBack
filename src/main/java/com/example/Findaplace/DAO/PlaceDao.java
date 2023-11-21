package com.example.Findaplace.DAO;

import com.example.Findaplace.model.FollowingRelation;
import com.example.Findaplace.model.Place;
import com.example.Findaplace.model.Review;
import com.example.Findaplace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceDao  extends JpaRepository<Place, Long> {

//    @Query("SELECT p FROM Place p WHERE p.review =:id_place_google")
//    Place getPlaceByGoogleId(String id_place_google);

    @Query("SELECT p FROM Place p " +
            "WHERE p.id_place_google =:google_id")
    Place findPlaceByGoogleId(String google_id);

}

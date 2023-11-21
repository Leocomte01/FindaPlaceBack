package com.example.Findaplace.controller;

import com.example.Findaplace.model.Place;
import com.example.Findaplace.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

    @ResponseBody
    @GetMapping("")
    public List<Place> getAllReviews() {
        return placeService.findAll();
    }

    @ResponseBody
    @GetMapping("/google/{id}")
    public Place findPlaceByGoogleId(@PathVariable String id) {
        return placeService.findPlaceByGoogleId(id);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<Place> findPlaceById(@PathVariable Long id) {
        return placeService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> addPlace(@RequestBody Place place) {
        try {
            placeService.addPlace(place);
            return ResponseEntity.ok().build(); // Return 200 OK for success
        } catch (Exception e) {
            logger.error("Error adding place", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding place: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void updatePlace(@PathVariable Long id){ placeService.updateById(id);}
}

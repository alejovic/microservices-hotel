package com.avg.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        service.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(service.getRatingHotelId(hotelId));
    }

}

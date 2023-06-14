package com.avg.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        service.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(hotel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        Hotel hotel = service.getHotel(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(hotel);

    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(){
        List<Hotel> hotels = service.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(hotels);
    }
}

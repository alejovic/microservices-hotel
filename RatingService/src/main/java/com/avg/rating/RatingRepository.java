package com.avg.rating;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    // custom
    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);


}

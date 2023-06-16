package com.avg.rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAll();

    Rating getRatingById(String id);

    List<Rating> getRatingByUserId(Long userid);

    List<Rating> getRatingHotelId(Long hotelId);

}

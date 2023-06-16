package com.avg.rating;

import com.avg.exception.ConstraintNotValid;
import com.avg.exception.ResourceNotFound;
import com.avg.validation.AdvanceInfo;
import com.avg.validation.BasicInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    private void checkValidation(Rating rating, Class<?> clazz) {
        final Set<ConstraintViolation<Rating>> constraintViolations =
                validator.validate(rating, clazz);
        for (ConstraintViolation<Rating> violation : constraintViolations) {
            throw new ConstraintNotValid(violation.getMessage());
        }
    }

    @Override
    public Rating create(Rating rating) {
        checkValidation(rating, BasicInfo.class);
        checkValidation(rating, AdvanceInfo.class);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return repository.findAll();
    }

    @Override
    public Rating getRatingById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new
                        ResourceNotFound("Rating id " + id + " does no exist!!"));
    }

    @Override
    public List<Rating> getRatingByUserId(Long userid) {
        return repository.findByUserId(userid);
    }

    @Override
    public List<Rating> getRatingHotelId(Long hotelId) {
        return repository.findByHotelId(hotelId);
    }
}

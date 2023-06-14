package com.avg.hotel;

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
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository repository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    private void checkValidation(Hotel hotel, Class<?> clazz) {
        final Set<ConstraintViolation<Hotel>> constraintViolations =
                validator.validate(hotel, clazz);
        for (ConstraintViolation<Hotel> violation : constraintViolations) {
            throw new ConstraintNotValid(violation.getMessage());
        }
    }

    @Override
    public Hotel create(Hotel hotel) {
        checkValidation(hotel, BasicInfo.class);
        checkValidation(hotel, AdvanceInfo.class);
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotel(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new
                        ResourceNotFound("Hotel id " + id + " does no exist!!"));
    }
}

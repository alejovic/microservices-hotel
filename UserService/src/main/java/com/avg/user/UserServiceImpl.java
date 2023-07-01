package com.avg.user;

import com.avg.exception.ConstraintNotValid;
import com.avg.exception.ResourceNotFound;
import com.avg.validation.AdvanceInfo;
import com.avg.validation.BasicInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    // The RestTemplate will be deprecated in a future version and will not have major new features added going forward.
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private void checkValidation(User user, Class<?> clazz) {
        final Set<ConstraintViolation<User>> constraintViolations =
                validator.validate(user, clazz);
        for (ConstraintViolation<User> violation : constraintViolations) {
            throw new ConstraintNotValid(violation.getMessage());
        }
    }

    @Override
    public User create(User user) {
        checkValidation(user, BasicInfo.class);
        checkValidation(user, AdvanceInfo.class);
        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long id) {
        // get the user from the local repository
        final User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User with id" + id + " is not found!"));

        // fetch rating from the RATING SERVICE
        // http://localhost:8083/ratings/users/{id}
        List<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/" + id, ArrayList.class);
        logger.info("{}", ratings);
        user.setRatings(ratings);
        return user;
    }
}

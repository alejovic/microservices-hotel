package com.avg.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User with id" + id + " is not found!"));
    }
}

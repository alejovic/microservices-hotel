package com.avg.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.create(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getUsers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(users);
    }

}

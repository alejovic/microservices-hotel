package com.avg.user.service;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getUsers();

    User getUser(Long id);
}

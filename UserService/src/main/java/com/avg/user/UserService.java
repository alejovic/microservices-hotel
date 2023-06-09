package com.avg.user;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getUsers();

    User getUser(Long id);
}

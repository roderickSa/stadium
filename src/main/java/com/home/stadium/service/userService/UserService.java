package com.home.stadium.service.userService;

import java.util.Optional;

import com.home.stadium.domain.model.User;

public interface UserService {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User save(User user);
}

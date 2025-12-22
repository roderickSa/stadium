package com.home.stadium.usecases;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.home.stadium.domain.model.User;
import com.home.stadium.exceptions.EmailAlreadyExistsException;
import com.home.stadium.exceptions.UsernameAlreadyExistsException;
import com.home.stadium.infrastructure.request.RegisterUserRequest;
import com.home.stadium.service.userService.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public User execute(RegisterUserRequest request) {

        if (userService.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }

        if (userService.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        return userService.save(user);
    }
}

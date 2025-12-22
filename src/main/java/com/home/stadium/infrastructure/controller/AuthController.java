package com.home.stadium.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.stadium.domain.model.User;
import com.home.stadium.infrastructure.mapper.RegisterUserResponseMapper;
import com.home.stadium.infrastructure.request.LoginRequest;
import com.home.stadium.infrastructure.request.RegisterUserRequest;
import com.home.stadium.infrastructure.response.RegisterUserResponse;
import com.home.stadium.service.security.CustomUserDetailsService;
import com.home.stadium.service.security.JwtService;
import com.home.stadium.usecases.RegisterUserUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final RegisterUserUseCase registerUserUseCase;
    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());

        return jwtService.generateToken(userDetails);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {

        User user = registerUserUseCase.execute(request);

        return ResponseEntity.ok(RegisterUserResponseMapper.toResponse(user));
    }
}

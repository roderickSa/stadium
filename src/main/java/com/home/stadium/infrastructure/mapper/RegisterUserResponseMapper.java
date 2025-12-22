package com.home.stadium.infrastructure.mapper;

import com.home.stadium.domain.model.User;
import com.home.stadium.infrastructure.response.RegisterUserResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterUserResponseMapper {
    public static RegisterUserResponse toResponse(User user) {
        return RegisterUserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}

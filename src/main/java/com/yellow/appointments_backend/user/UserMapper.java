package com.yellow.appointments_backend.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.user.dto.UserCreateDto;
import com.yellow.appointments_backend.user.dto.UserResponseDto;

@Service
public class UserMapper {

    public User toUser(UserCreateDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPhoneNumber(dto.phoneNumber());
        user.setPassword(dto.password());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public UserResponseDto toUserResponseDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber());
    }
}

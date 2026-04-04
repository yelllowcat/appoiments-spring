package com.yellow.appoiments_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.UserResponseDto;
import com.yellow.appoiments_backend.mappers.UserMapper;
import com.yellow.appoiments_backend.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponseDto)
                .collect(java.util.stream.Collectors.toList());
    }
}

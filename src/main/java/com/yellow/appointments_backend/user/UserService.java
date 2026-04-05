package com.yellow.appointments_backend.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.user.dto.UserResponseDto;

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

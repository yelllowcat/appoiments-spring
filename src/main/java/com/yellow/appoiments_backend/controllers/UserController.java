package com.yellow.appoiments_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appoiments_backend.dtos.UserResponseDto;
import com.yellow.appoiments_backend.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return userService.getAllUsers();
    }
}

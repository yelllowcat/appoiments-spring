package com.yellow.appointments_backend.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appointments_backend.user.dto.UserResponseDto;

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

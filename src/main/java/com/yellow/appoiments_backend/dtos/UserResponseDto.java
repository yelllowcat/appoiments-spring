package com.yellow.appoiments_backend.dtos;

public record UserResponseDto(
        Long id,
        String username,
        String email,
        String phoneNumber) {

}

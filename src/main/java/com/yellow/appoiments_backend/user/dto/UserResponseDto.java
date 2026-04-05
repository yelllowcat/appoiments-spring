package com.yellow.appoiments_backend.user.dto;

public record UserResponseDto(
                Long id,
                String username,
                String email,
                String phoneNumber) {

}

package com.yellow.appoiments_backend.barber.dto;

public record BarberCreateDto(
                String username,
                String email,
                String phoneNumber,
                String password) {

}

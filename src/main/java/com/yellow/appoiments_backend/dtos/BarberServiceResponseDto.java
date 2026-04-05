package com.yellow.appoiments_backend.dtos;

public record BarberServiceResponseDto(
                Long id,
                String name,
                String description,
                Double price,
                Boolean isActive

) {
}

package com.yellow.appoiments_backend.OfferedService.dto;

public record BarberServiceResponseDto(
        Long id,
        String name,
        String description,
        Double price,
        Boolean isActive

) {
}

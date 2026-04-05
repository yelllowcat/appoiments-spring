package com.yellow.appointments_backend.OfferedService.dto;

public record OfferedServiceResponseDto(
                Long id,
                String name,
                String description,
                Double price,
                Boolean isActive

) {
}

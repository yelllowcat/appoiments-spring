package com.yellow.appoiments_backend.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;

public record BarberServiceUpdateDto(
                @Nullable String name,
                @Nullable String description,
                @Nullable @Positive Double price,
                @Nullable Boolean isActive) {

}

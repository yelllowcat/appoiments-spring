package com.yellow.appointments_backend.appointment.dto;

import java.time.LocalDateTime;

import com.yellow.appointments_backend.utils.AppointmentStatus;

import jakarta.validation.constraints.NotNull;

public record AppointmentCreateDto(
                @NotNull Long serviceId,
                @NotNull Long barberId,
                @NotNull Long clientId,
                @NotNull LocalDateTime appointmentDate,
                @NotNull AppointmentStatus status) {

}

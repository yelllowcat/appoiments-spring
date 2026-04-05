package com.yellow.appointments_backend.appointment.dto;

import java.time.LocalDateTime;

import com.yellow.appointments_backend.utils.AppointmentStatus;

public record AppointmentResponseDto(
                Long id,
                Long serviceId,
                Long barberId,
                Long clientId,
                LocalDateTime appointmentDate,
                AppointmentStatus status) {

}

package com.yellow.appointments_backend.appointment;

import java.time.LocalDateTime;

import com.yellow.appointments_backend.barber.Barber;
import com.yellow.appointments_backend.client.Client;
import com.yellow.appointments_backend.models.BaseEntity;
import com.yellow.appointments_backend.offeredService.OfferedService;
import com.yellow.appointments_backend.utils.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Appointment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private OfferedService service;

    @ManyToOne
    @JoinColumn(name = "barber_id", nullable = false)
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

}

package com.yellow.appoiments_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Appoiment extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "service_id", nullable = false)
    private BarberService service;

    @OneToOne
    @JoinColumn(name = "barber_id", nullable = false)
    private Barber barber;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "appoiment_date", nullable = false)
    private String appoimentDate;

    @Column(name = "status", nullable = false)
    private String status;

}

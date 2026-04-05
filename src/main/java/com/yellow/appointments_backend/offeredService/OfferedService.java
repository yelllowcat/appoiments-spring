package com.yellow.appointments_backend.OfferedService;

import com.yellow.appointments_backend.models.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class OfferedService extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean isActive;

}

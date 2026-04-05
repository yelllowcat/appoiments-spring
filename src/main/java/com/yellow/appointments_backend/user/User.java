package com.yellow.appointments_backend.user;

import com.yellow.appointments_backend.barber.Barber;
import com.yellow.appointments_backend.client.Client;
import com.yellow.appointments_backend.models.BaseEntity;
import com.yellow.appointments_backend.utils.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = true, unique = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Barber barber;
}

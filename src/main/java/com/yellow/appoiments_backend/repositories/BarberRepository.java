package com.yellow.appoiments_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellow.appoiments_backend.models.Barber;

public interface BarberRepository extends JpaRepository<Barber, Long> {

}

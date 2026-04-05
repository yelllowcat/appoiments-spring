package com.yellow.appoiments_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellow.appoiments_backend.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}

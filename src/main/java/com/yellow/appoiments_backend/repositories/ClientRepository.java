package com.yellow.appoiments_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellow.appoiments_backend.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

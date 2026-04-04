package com.yellow.appoiments_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yellow.appoiments_backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

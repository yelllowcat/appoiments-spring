package com.yellow.appoiments_backend.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.ClientCreateDto;
import com.yellow.appoiments_backend.dtos.ClientResponseDto;
import com.yellow.appoiments_backend.models.Client;
import com.yellow.appoiments_backend.models.User;
import com.yellow.appoiments_backend.utils.Role;

@Service
public class ClientMapper {

    public Client toClient(ClientCreateDto clientCreateDto) {
        if (clientCreateDto == null) {
            return null;
        }
        Client client = new Client();
        User user = new User();

        user.setCreatedAt(LocalDateTime.now());
        user.setRole(Role.CLIENT);
        user.setUsername("dada");

        client.setUser(user);
        client.getUser().setUsername(clientCreateDto.username());
        client.getUser().setEmail(clientCreateDto.email());
        client.getUser().setPhoneNumber(clientCreateDto.phoneNumber());
        client.getUser().setPassword(clientCreateDto.password());
        client.setCreatedAt(LocalDateTime.now());

        return client;
    }

    public ClientResponseDto toClientResponseDto(Client client) {
        if (client == null) {
            return null;
        }
        return new ClientResponseDto(
                client.getId(),
                client.getUser().getUsername(),
                client.getUser().getEmail(),
                client.getUser().getPhoneNumber());

    }
}

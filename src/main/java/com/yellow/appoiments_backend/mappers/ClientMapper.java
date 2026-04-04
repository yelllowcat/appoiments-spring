package com.yellow.appoiments_backend.mappers;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.ClientCreateDto;
import com.yellow.appoiments_backend.dtos.ClientResponseDto;
import com.yellow.appoiments_backend.models.Client;
import com.yellow.appoiments_backend.models.User;
import com.yellow.appoiments_backend.utils.Role;

@Service
public class ClientMapper {

    public Client toClient(ClientCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        User user = new User();

        user.setRole(Role.CLIENT);

        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPhoneNumber(dto.phoneNumber());
        user.setPassword(dto.password());
        client.setUser(user);

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

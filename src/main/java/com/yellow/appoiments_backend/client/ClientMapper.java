package com.yellow.appoiments_backend.client;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.client.dto.ClientCreateDto;
import com.yellow.appoiments_backend.client.dto.ClientResponseDto;
import com.yellow.appoiments_backend.user.User;
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

package com.yellow.appoiments_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.ClientCreateDto;
import com.yellow.appoiments_backend.dtos.ClientResponseDto;
import com.yellow.appoiments_backend.mappers.ClientMapper;
import com.yellow.appoiments_backend.models.Client;
import com.yellow.appoiments_backend.models.User;
import com.yellow.appoiments_backend.repositories.ClientRepository;
import com.yellow.appoiments_backend.utils.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public List<ClientResponseDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toClientResponseDto)
                .collect(java.util.stream.Collectors.toList());
    }

    public ClientResponseDto createClient(ClientCreateDto dto) {
        System.out.println("Creating client with username: " + dto.username());
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .phoneNumber(dto.phoneNumber())
                .password(dto.password())
                .createdAt(java.time.LocalDateTime.now())
                .role(Role.CLIENT)
                .build();

        Client client = Client.builder()
                .user(user)
                .createdAt(java.time.LocalDateTime.now())
                .build();

        user.setClient(client);
        client.setUser(user);
        Client savedClient = clientRepository.save(client);

        return clientMapper.toClientResponseDto(savedClient);
    }
}

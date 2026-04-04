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

    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return clientMapper.toClientResponseDto(client);
    }

    public ClientResponseDto createClient(ClientCreateDto dto) {

        Client client = clientMapper.toClient(dto);

        client.getUser().setPassword(dto.password());
        client.getUser().setRole(Role.CLIENT);

        Client savedClient = clientRepository.save(client);

        return clientMapper.toClientResponseDto(savedClient);
    }

    public ClientResponseDto updateClient(Long id, ClientCreateDto dto) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        User user = existingClient.getUser();

        if (dto.username() != null && !dto.username().isEmpty()) {
            user.setUsername(dto.username());

        }
        if (dto.email() != null && !dto.email().isEmpty()) {
            user.setEmail(dto.email());
        }
        if (dto.phoneNumber() != null && !dto.phoneNumber().isEmpty()) {
            user.setPhoneNumber(dto.phoneNumber());
        }
        if (dto.password() != null && !dto.password().isEmpty()) {
            user.setPassword(dto.password());
        }

        Client updatedClient = clientRepository.save(existingClient);

        return clientMapper.toClientResponseDto(updatedClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}

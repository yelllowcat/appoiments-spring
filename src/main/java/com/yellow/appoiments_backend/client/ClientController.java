package com.yellow.appoiments_backend.client;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appoiments_backend.client.dto.ClientCreateDto;
import com.yellow.appoiments_backend.client.dto.ClientResponseDto;
import com.yellow.appoiments_backend.client.dto.ClientUpdateDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public List<ClientResponseDto> getClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/clients")
    public ClientResponseDto createClient(
            @Valid @RequestBody ClientCreateDto dto) {
        return clientService.createClient(dto);
    }

    @PostMapping("/clients/{id}")
    public ClientResponseDto updateClient(
            @PathVariable Long id,
            @Valid @RequestBody ClientUpdateDto dto) {

        return clientService.updateClient(id, dto);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}

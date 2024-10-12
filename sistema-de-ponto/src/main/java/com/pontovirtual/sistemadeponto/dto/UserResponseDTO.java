package com.pontovirtual.sistemadeponto.dto;

import com.pontovirtual.sistemadeponto.model.User;

public record UserResponseDTO(Long id, String name, String cpf, String cargo) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getCpf(), user.getCargo());
    }
}

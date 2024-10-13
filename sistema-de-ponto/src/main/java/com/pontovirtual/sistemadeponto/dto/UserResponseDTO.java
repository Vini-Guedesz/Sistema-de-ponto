package com.pontovirtual.sistemadeponto.dto;

import com.pontovirtual.sistemadeponto.model.UserModel;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserResponseDTO(UUID id,String name,String cpf,String cargo) {

    public UserResponseDTO(UserModel userModel) {
        this(userModel.getId(), userModel.getName(), userModel.getCpf(), userModel.getCargo());
    }
}

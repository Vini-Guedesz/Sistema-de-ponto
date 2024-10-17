package com.pontovirtual.sistemadeponto.dto;

import jakarta.validation.constraints.NotBlank;


public record UserRequestDTO(@NotBlank String name, @NotBlank String cpf, @NotBlank String role) {


}

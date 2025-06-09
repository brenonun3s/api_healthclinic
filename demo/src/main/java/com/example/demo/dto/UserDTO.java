package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserDTO(
        @NotBlank(message = "Username is required for registry!")
        String username,
        @NotBlank(message = "Password is required for registry!")
        String password,
        List<String> roles) {
}

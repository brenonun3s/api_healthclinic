package com.example.demo.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "Username is required for registry!")
        String username,
        List<String> roles) {
}

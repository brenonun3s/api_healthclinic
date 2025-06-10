package com.example.demo.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record  UserCreateDTO(        
        @NotBlank(message = "Username is required for registry!")
        String username,
        @NotBlank(message = "Password is required for registry!")
        String password,
        List<String> roles) {

}

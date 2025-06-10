package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(

        @NotBlank(message = "Username is required for update!")
        String username
) {

}

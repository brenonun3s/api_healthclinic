package com.example.demo.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PatientDTO(
        @NotBlank(message = "Name for patient is required for registration!")
        String name,
        @CPF(message = "Input CPF is invalid")
        String cpf,
        @NotBlank(message = "Phone Number for patient is required for registration!")
        String phone,
        @Future(message = "Birth Date for patient can't be future!")
        LocalDate birthDate
) {
}

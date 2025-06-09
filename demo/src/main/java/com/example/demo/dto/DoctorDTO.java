package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record DoctorDTO(
        @NotBlank(message = "Name for Doctor is required for registration!")
        String name,
        @NotBlank(message = "Name for Doctor is required for registration!")
        String speciality,
        @NotBlank(message = "Number of Federal Council of Medicine of Brazil(CRM) for Doctor is required for registration!")
        String crm

) {
}

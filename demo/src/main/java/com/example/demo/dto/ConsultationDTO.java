package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ConsultationDTO (
        @Schema(description = "Patient appointment date", example = "23/06/2025")
        @Past(message = "It is not possible to make an appointment for a date that has already passed!")
        LocalDate consultationDate,

        @Schema(description = "Name of Patient", example = "Breno Nunes")
        @NotNull(message = "Patient is required for registry of Consultation!")
        PatientDTO patient,

        @Schema(description = "Doctor who will attend to the patient", example = "Dra Laura")
        @NotNull(message = "The doctor is obliged to record the Consultation!")
        DoctorDTO doctor

) {
}
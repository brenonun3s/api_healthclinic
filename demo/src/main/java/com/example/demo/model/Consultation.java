package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_consultas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_scheduling", nullable = false)
    private LocalDate consultationDate;

    @ManyToOne
    @Column(name = "patiente_scheduled", nullable = false)
    private Patient patient;

    @ManyToOne
    @Column(name = "doctor_scheduled", nullable = false)
    private Doctor doctor;

}

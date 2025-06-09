package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_patient", nullable = false)
    private String name;

    @Column(name = "cpf_patient", nullable = false)
    private String cpf;

    @Column(name = "phone_patient", nullable = false)
    private String phone;

    @Column(name = "birthdate_patient", nullable = false)
    private LocalDate birthDate;


}

package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    private Long id;

    @Column(name = "name_doctor", nullable = false)
    private String name;

    @Column(name = "specialty_doctor", nullable = false)
    private String specialty;

    @Column(name = "crm_doctor", nullable = false)
    private String crm;



}

package com.example.demo.model;

import com.example.demo.model.enumerators.StatusConsultation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scheduling_date", nullable = false)
    private LocalDate schedulingDate;

    @ManyToOne
    @JoinColumn(name = "patient_scheduled", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_scheduled", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusConsultation status;

    @CreationTimestamp
    private LocalDateTime createdAt;


}

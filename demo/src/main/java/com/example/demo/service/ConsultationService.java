package com.example.demo.service;

import com.example.demo.dto.ConsultationCreatedDTO;
import com.example.demo.dto.ConsultationDTO;
import com.example.demo.dto.ConsultationUpdateDTO;
import com.example.demo.exceptions.ConsultationIdNotFoundException;
import com.example.demo.exceptions.PatientIdNotFoundException;
import com.example.demo.mapper.ConsultationMapper;
import com.example.demo.model.Consultation;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    @Autowired
    private ConsultationMapper mapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public ConsultationDTO requestConsultation(ConsultationCreatedDTO consultation) {

        Patient patient = patientRepository.findById(consultationDTO.getPatientId())
                .orElseThrow(() -> new PatientIdNotFoundException(consultationDTO.getPatientId()));


        Doctor doctor = doctorRepository.findById(consultationDTO.getDoctorId())
                .orElseThrow(() -> new DoctorIdNotFoundException(consultationDTO.getDoctorId()));
        Consultation entity = mapper.toEntity(consultation);
        Consultation savedConsultation = repository.save(entity);
        return mapper.toDTO(savedConsultation);
    }

    @Transactional(readOnly = true)
    public List<ConsultationDTO> findAllConsultations() {
        List<Consultation> consultations = repository.findAll();
        return consultations
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ConsultationDTO findConsultationById(Long id) {
        Consultation consultation = repository.findById(id)
                .orElseThrow(() -> new ConsultationIdNotFoundException(id));
        return mapper.toDTO(consultation);

    }

    @Transactional
    public void deleteConsultation(Long id) {
        Consultation consultation =
                repository.findById(id)
                        .orElseThrow(() -> new ConsultationIdNotFoundException(id));
        repository.delete(consultation);
    }

    @Transactional
    public ConsultationDTO updateConsultation(Long id, ConsultationUpdateDTO consultationUpdateDTO) {
        Consultation consultationExisting = repository.findById(id)
                .orElseThrow(() -> new ConsultationIdNotFoundException(id));

        mapper.updateConsultationFromDTO(consultationUpdateDTO, consultationExisting);

        Consultation updateConsultation = repository.save(consultationExisting);
        return mapper.toDTO(updateConsultation);
    }


}

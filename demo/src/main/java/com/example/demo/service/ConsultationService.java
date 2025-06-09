package com.example.demo.service;

import com.example.demo.model.Consultation;
import com.example.demo.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    public Consultation requestConsultation(Consultation consultation) {
        return repository.save(consultation);
    }

    public List<Consultation> getAllConsultations() {
        return repository.findAll();
    }

    public Consultation getConsultationById(Long id) {
        return repository.findById(id).get();
    }

    public Consultation rescheduleConsultation(Consultation consultation) {
        return repository.save(consultation);
    }

    public void cancelConsultation(Consultation consultation) {
        repository.delete(consultation);
    }





}

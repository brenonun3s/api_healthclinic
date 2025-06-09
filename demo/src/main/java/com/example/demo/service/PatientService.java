package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient registryPatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updateDoctor(Patient patient) {
        return repository.save(patient);
    }

    public void deletePatient(Patient patient) {
        repository.delete(patient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientForId(Long id) {
        return repository.findById(id).get();
    }



}

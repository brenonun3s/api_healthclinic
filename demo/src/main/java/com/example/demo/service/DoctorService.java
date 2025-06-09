package com.example.demo.service;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor registryDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        repository.delete(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id).get();
    }

}

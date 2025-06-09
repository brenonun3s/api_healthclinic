package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private static final String ROLE_DOCTOR = "ROLE_DOCTOR";
    private static final String ROLE_RECEPTIONIST = "ROLE_RECEPTIONIST";
    private static final String ROLE_PATIENT = "ROLE_PATIENT";

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public User registerReceptionist(UserDTO dto) {
        User user = mapper.toEntity(dto);
        user.setRoles(ROLE_RECEPTIONIST);
        return repository.save(user);
    }

    public User registerUserDoctor(UserDTO dto) {
        User user = mapper.toEntity(dto);
        user.setRoles(ROLE_DOCTOR);
        return repository.save(user);
    }

    public User registerUserPatient(UserDTO dto) {
        User user = mapper.toEntity(dto);
        user.setRoles(ROLE_PATIENT);
        return repository.save(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new IdNotFoundException(id));
    
    }


}

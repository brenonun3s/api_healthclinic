package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateDTO;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.enumroles.Role;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repository;

    private final UserMapper mapper;


    @Transactional
    public UserDTO createUser(UserCreateDTO dto, Role role) {
        User user = mapper.toEntity(dto);
        user.setRole(role);
        User savedUser = repository.save(user);
        return mapper.toDTO(savedUser);
    }

    @Transactional
    public UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User userExisting = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        
                mapper.updateUserFromDTO(userUpdateDTO, userExisting);

        User updatedUser = repository.save(userExisting);
        return mapper.toDTO(updatedUser);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(mapper::toDTO)
                .toList();
        
    }

    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        return mapper.toDTO(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        repository.delete(user);
    }


}

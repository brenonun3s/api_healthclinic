package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateDTO;
import com.example.demo.model.enumerators.Role;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @Operation(summary = "Create a Doctor", description = "Create a new doctor in the system")
    @ApiResponse(responseCode = "200", description = "Doctor created successfully")
    @PostMapping("/register-doctor")
    public ResponseEntity<UserDTO> createUserDoctor(@RequestBody @Valid UserCreateDTO dto) {
        UserDTO createdUser = service.createUser(dto, Role.DOCTOR);
        return ResponseEntity.ok(createdUser);
    }

    @Operation(summary = "Create a Docor", description = "Create a new receptionist in the system")
    @ApiResponse(responseCode = "200", description = "Receptionist created successfully")
    @PostMapping("/register-receptionist")
    public ResponseEntity<UserDTO> createUserReceptionist(@RequestBody @Valid UserCreateDTO dto) {
        UserDTO createdUser = service.createUser(dto, Role.RECEPTIONIST);
        return ResponseEntity.ok(createdUser);
    }

    @Operation(summary = "Create a Patient", description = "Create a new patient in the system")
    @ApiResponse(responseCode = "200", description = "Patient created successfully")
    @PostMapping("/register-patient")
    public ResponseEntity<UserDTO> createUserPatient(@RequestBody @Valid UserCreateDTO dto) {
        UserDTO createdUser = service.createUser(dto, Role.PATIENT);
        return ResponseEntity.ok(createdUser);
    }

    @Operation(summary = "Return All Users", description = "Return users registered in the system")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Search user by ID", description = "Receives an ID and searches for the user using it")
    @ApiResponse(responseCode = "200", description = "Localized User")
    @ApiResponse(responseCode = "404", description = "User not found with the searched ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO user = service.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Delete User", description = "Receives a Id User and delete it in the system")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @ApiResponse(responseCode = "404", description = "User not found with the searched ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update User", description = "Receives a Id User and updates it in the system")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @ApiResponse(responseCode = "404", description = "User not found with the searched ID")
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        service.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok("User updated successfully!");
    }

}

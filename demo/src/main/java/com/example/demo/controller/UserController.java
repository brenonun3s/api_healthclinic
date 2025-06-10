package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateDTO;
import com.example.demo.model.User;
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

    @Operation(summary = "Create a new Doctor", description = "Receives data from a user and saves it in the system")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/register-doctor")
    public ResponseEntity<?> createUserDoctor(@RequestBody @Valid UserDTO userDTO) {
        service.registerUserDoctor(userDTO);
        return ResponseEntity.ok("User Doctor created successfully!");
    }

    @Operation(summary = "Create a new Receptionist", description = "Receives data from a user and saves it in the system")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/register-receptionist")
    public ResponseEntity<?> createUserReceptionist(@RequestBody @Valid UserDTO userDTO) {
        service.registerReceptionist(userDTO);
        return ResponseEntity.ok("User Receptionist created successfully!");
    }

    @Operation(summary = "Create a new Patient", description = "Receives data from a user and saves it in the system")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/register-patient")
    public ResponseEntity<?> createUserPatient(@RequestBody @Valid UserDTO userDTO) {
        service.registerUserPatient(userDTO);
        return ResponseEntity.ok("User Patient created successfully!");
    }

    @Operation(summary = "Return All Users", description = "Return users registered in the system")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users =service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Search user by ID", description = "Receives an ID and searches for the user using it")
    @ApiResponse(responseCode = "200", description = "Localized User")
    @ApiResponse(responseCode = "404", description = "User not found with the searched ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = service.getUserById(id);
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
    @PostMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        service.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok("User updated successfully!");
    }

    

}

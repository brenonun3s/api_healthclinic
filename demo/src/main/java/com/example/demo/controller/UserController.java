package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @Operation(
            summary = "Create a new Doctor",
            description = "Receives data from a user and saves it in the system"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User created successfully"
    )
    @PostMapping
    public ResponseEntity<?> createUserDoctor(@RequestBody @Valid UserDTO userDTO) {
        service.registerUserDoctor(userDTO);
        return ResponseEntity.ok("User Doctor created successfully!");
    }

    @PostMapping
    public ResponseEntity<?> createUserReceptionist(@RequestBody @Valid UserDTO userDTO) {
        service.registerReceptionist(userDTO);
        return ResponseEntity.ok("User Receptionist created successfully!");
    }

    @PostMapping
    public ResponseEntity<?> createUserPatient(@RequestBody @Valid UserDTO userDTO) {
        service.registerUserPatient(userDTO);
        return ResponseEntity.ok("User Patient created successfully!");
    }




}

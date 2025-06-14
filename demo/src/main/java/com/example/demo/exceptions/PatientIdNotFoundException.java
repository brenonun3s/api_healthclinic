    package com.example.demo.exceptions;



    public class PatientIdNotFoundException extends RuntimeException{
        public PatientIdNotFoundException(Long id) {
            super("Patient with that ID" + id + "not found");
        }
    }

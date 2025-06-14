    package com.example.demo.exceptions;



    public class ConsultationIdNotFoundException extends RuntimeException{
        public ConsultationIdNotFoundException(Long id) {
            super("Consultation with that ID" + id + "not found");
        }
    }

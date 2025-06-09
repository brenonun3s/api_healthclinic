    package com.example.demo.exceptions;



    public class IdNotFoundException extends RuntimeException{
        public IdNotFoundException(Long id) {
            super("User with that ID" + id + "not found");
        }
    }

    package com.example.demo.exceptions;



    public class UserIdNotFoundException extends RuntimeException{
        public UserIdNotFoundException(Long id) {
            super("User with that ID" + id + "not found");
        }
    }

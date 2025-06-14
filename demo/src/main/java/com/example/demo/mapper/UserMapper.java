package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateDTO;
import com.example.demo.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    UserDTO toDTO(User user);

    void updateUserFromDTO(UserUpdateDTO dto, @MappingTarget User entity);

}

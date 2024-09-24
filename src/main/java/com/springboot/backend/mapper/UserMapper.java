package com.springboot.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.springboot.backend.dto.request.UserCreation;
import com.springboot.backend.dto.request.UserUpdate;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
        User toUser(UserCreation request);

        void update(@MappingTarget User user, UserUpdate request);

        UserResponse toUserResponse(User user);

}

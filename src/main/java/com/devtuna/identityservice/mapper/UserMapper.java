package com.devtuna.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.devtuna.identityservice.dto.request.UserCreationRequest;
import com.devtuna.identityservice.dto.request.UserUpdateRequest;
import com.devtuna.identityservice.dto.response.UserResponse;
import com.devtuna.identityservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

package com.devtuna.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devtuna.identityservice.dto.request.RoleRequest;
import com.devtuna.identityservice.dto.response.RoleResponse;
import com.devtuna.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}

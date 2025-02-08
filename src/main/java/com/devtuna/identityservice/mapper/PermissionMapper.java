package com.devtuna.identityservice.mapper;

import org.mapstruct.Mapper;

import com.devtuna.identityservice.dto.request.PermissionRequest;
import com.devtuna.identityservice.dto.response.PermissionResponse;
import com.devtuna.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}

package com.devtuna.identityservice.service;

import com.devtuna.identityservice.dto.request.PermissionRequest;
import com.devtuna.identityservice.dto.response.PermissionResponse;
import com.devtuna.identityservice.entity.Permission;
import com.devtuna.identityservice.mapper.PermissionMapper;
import com.devtuna.identityservice.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepo;
    private final PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepo.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepo.findAll();

        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permissionName) {
        permissionRepo.deleteById(permissionName);
    }
}

package com.devtuna.identityservice.service;

import com.devtuna.identityservice.dto.request.PermissionRequest;
import com.devtuna.identityservice.dto.request.RoleRequest;
import com.devtuna.identityservice.dto.response.PermissionResponse;
import com.devtuna.identityservice.dto.response.RoleResponse;
import com.devtuna.identityservice.entity.Permission;
import com.devtuna.identityservice.mapper.PermissionMapper;
import com.devtuna.identityservice.mapper.RoleMapper;
import com.devtuna.identityservice.repository.PermissionRepository;
import com.devtuna.identityservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;
    private final RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepo.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepo.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepo.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role) {
        roleRepo.deleteById(role);
    }
}
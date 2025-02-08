package com.devtuna.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtuna.identityservice.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {}

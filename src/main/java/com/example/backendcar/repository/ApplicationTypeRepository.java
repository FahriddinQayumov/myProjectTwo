package com.example.backendcar.repository;

import com.example.backendcar.model.ApplicationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, UUID> {
}

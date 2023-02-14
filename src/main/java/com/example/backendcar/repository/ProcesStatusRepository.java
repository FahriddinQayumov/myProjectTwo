package com.example.backendcar.repository;

import com.example.backendcar.model.ProcessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcesStatusRepository extends JpaRepository<ProcessStatus, UUID> {
}

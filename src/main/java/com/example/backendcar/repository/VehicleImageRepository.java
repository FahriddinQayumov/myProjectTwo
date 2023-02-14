package com.example.backendcar.repository;

import com.example.backendcar.model.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VehicleImageRepository extends JpaRepository<VehicleImage, UUID> {
}

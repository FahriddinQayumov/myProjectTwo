package com.example.backendcar.repository;

import com.example.backendcar.model.BodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, UUID> {
}

package com.example.backendcar.service;

import com.example.backendcar.dto.applicationtype.ApplicationTypeCreateDto;
import com.example.backendcar.dto.applicationtype.ApplicationTypeDetailDto;
import com.example.backendcar.model.ApplicationType;
import com.example.backendcar.repository.ApplicationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationTypeService {
    @Autowired
    public ApplicationTypeRepository applicationTypeRepository;

    public void create(ApplicationTypeCreateDto applicationTypeCreateDto) {
        ApplicationType entity = new ApplicationType();
        convertDtoToEntity(applicationTypeCreateDto, entity);
        applicationTypeRepository.save(entity);
    }


    private void convertDtoToEntity(ApplicationTypeCreateDto dto, ApplicationType entity) {
        entity.setName(dto.getName());
        entity.setDisplayClass(dto.getDisplayClass());
        entity.setDisplayName(dto.getDisplayName());
        entity.setDisplayIcon(dto.getDisplayIcon());
    }

    public ApplicationTypeDetailDto get(UUID id) {
        ApplicationType entity = getEntity(id);
        ApplicationTypeDetailDto dto = new ApplicationTypeDetailDto();
        return conertEntityToDto(entity, dto);
    }

    public void update(UUID id, ApplicationTypeCreateDto dto) {
        ApplicationType entity = getEntity(id);
        convertDtoToEntity(dto, entity);
        applicationTypeRepository.save(entity);
    }

    public void delete(UUID id) {
        getEntity(id);
        applicationTypeRepository.deleteById(id);
    }

    public List<ApplicationTypeDetailDto> getAll() {
        List<ApplicationType> applications = applicationTypeRepository.findAll();
        List<ApplicationTypeDetailDto> dtos = new ArrayList<>();
        for (ApplicationType application : applications) {
            dtos.add(conertEntityToDto(application, new ApplicationTypeDetailDto()));
        }
        return dtos;
    }


    private ApplicationTypeDetailDto conertEntityToDto(ApplicationType entity, ApplicationTypeDetailDto dto) {
        dto.setDisplayClass(entity.getDisplayClass());
        dto.setDisplayIcon(entity.getDisplayIcon());
        dto.setDisplayName(entity.getDisplayName());
        dto.setName(entity.getName());
        return dto;
    }

    public ApplicationType getEntity(UUID id) {
        Optional<ApplicationType> optional = applicationTypeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("application not found");
        }
        return optional.get();
    }
}

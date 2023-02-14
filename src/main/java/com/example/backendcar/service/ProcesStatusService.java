package com.example.backendcar.service;

import com.example.backendcar.dto.processtatus.ProcesStatusCreateDto;
import com.example.backendcar.dto.processtatus.ProcesStatusDetailDto;
import com.example.backendcar.model.ProcessStatus;
import com.example.backendcar.repository.ProcesStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcesStatusService {
    @Autowired
    private ProcesStatusRepository procesStatusRepository;


    public void create(ProcesStatusCreateDto procesStatusCreateDto) {
        ProcessStatus entity = new ProcessStatus();
        convertDtoToEntity(procesStatusCreateDto, entity);
        procesStatusRepository.save(entity);
    }

    public ProcesStatusDetailDto get(UUID id) {
        ProcessStatus entity = getEntity(id);
        ProcesStatusDetailDto dto = new ProcesStatusDetailDto();
        return conertEntityToDto(entity, dto);
    }

    public void update(UUID id, ProcesStatusCreateDto dto) {
        ProcessStatus entity = getEntity(id);
        convertDtoToEntity(dto, entity);
        procesStatusRepository.save(entity);
    }

    public void delete(UUID id) {
        getEntity(id);
        procesStatusRepository.deleteById(id);
    }

    public List<ProcesStatusDetailDto> getAll() {
        List<ProcessStatus> applications = procesStatusRepository.findAll();
        List<ProcesStatusDetailDto> dtos = new ArrayList<>();
        for (ProcessStatus application : applications) {
            dtos.add(conertEntityToDto(application, new ProcesStatusDetailDto()));
        }
        return dtos;
    }

    private ProcessStatus getEntity(UUID id) {
        Optional<ProcessStatus> optional = procesStatusRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("application not found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(ProcesStatusCreateDto dto, ProcessStatus entity) {
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplay_name());
    }

    private ProcesStatusDetailDto conertEntityToDto(ProcessStatus entity, ProcesStatusDetailDto dto) {
        dto.setName(entity.getName());
        dto.setDisplay_name(entity.getDisplayName());
        return dto;
    }
}

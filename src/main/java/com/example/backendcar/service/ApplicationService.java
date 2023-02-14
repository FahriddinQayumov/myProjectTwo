package com.example.backendcar.service;

import com.example.backendcar.dto.apllication.ApplicationCreateDto;
import com.example.backendcar.dto.apllication.ApplicationDetailDto;
import com.example.backendcar.model.Application;
import com.example.backendcar.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;


    public void create(ApplicationCreateDto applicationdto) {
        Application entity = new Application();
        conertDtoToEntity(applicationdto, entity);
        applicationRepository.save(entity);

    }


    public ApplicationDetailDto get(UUID id) {
        Application entity = getEntity(id);
        ApplicationDetailDto dto = new ApplicationDetailDto();
        return conertEntityToDto(entity, dto);
    }


    public Application getEntity(UUID id) {
        Optional<Application> optional = applicationRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("application not found");
        }
        return optional.get();
    }

    public ApplicationDetailDto conertEntityToDto(Application entity, ApplicationDetailDto dto) {
        dto.setApplicationType(entity.getApplicationtype());
        dto.setApplicationTypeId(entity.getApplicationtypeId());
        dto.setUserId(entity.getUserId());
        dto.setUser(entity.getUser());
        dto.setMerchanId(entity.getMerchantId());
        dto.setMerchant(entity.getMerchant());
        dto.setVehicleId(entity.getVehicle_id());
        dto.setVehicle(entity.getVehicle());
        dto.setPrice(entity.getPrice());
        dto.setConditionDuration(entity.getConditionDuration());
        dto.setConditionDurationType(entity.getConditionDurationType());
        dto.setConditionPrice(entity.getConditionPrice());
        dto.setProcessStatusId(entity.getProcesStatusId());
        dto.setProcessStatus(entity.getProcessStatus());
        return dto;

    }

    public void conertDtoToEntity(ApplicationCreateDto dto, Application entity) {
        entity.setApplicationtypeId(dto.getApplicationTypeId());
        entity.setMerchantId(dto.getMerchanId());
        entity.setPrice(dto.getPrice());
        entity.setConditionDuration(dto.getConditionDuration());
        entity.setConditionDurationType(dto.getConditionDurationType());
        entity.setUserId(dto.getUserId());
        entity.setConditionPrice(dto.getConditionPrice());
        entity.setVehicle_id(dto.getVehicleId());
        entity.setProcesStatusId(dto.getProcessStatusId());
    }


    public void update(UUID id, ApplicationCreateDto dto) {
        Application entity = getEntity(id);
        conertDtoToEntity(dto, entity);
        applicationRepository.save(entity);
    }

    public void delete(UUID id) {
        getEntity(id);
        applicationRepository.deleteById(id);
    }

    public List<ApplicationDetailDto> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationDetailDto> dtos = new ArrayList<>();
        for (Application application : applications) {
            dtos.add(conertEntityToDto(application, new ApplicationDetailDto()));
        }
        return dtos;
    }
}

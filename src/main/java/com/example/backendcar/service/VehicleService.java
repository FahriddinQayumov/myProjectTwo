package com.example.backendcar.service;

import com.example.backendcar.dto.vehicle.VehicleCreateDto;
import com.example.backendcar.dto.vehicle.VehicleDetailDto;
import com.example.backendcar.model.Model;
import com.example.backendcar.model.Vehicle;
import com.example.backendcar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public void create(VehicleCreateDto dto){
        Vehicle entity=new Vehicle();
        convertDtoToEntity(entity,dto);
        vehicleRepository.save(entity);
    }

    public VehicleDetailDto get(UUID id){
        Vehicle entity=getEntity(id);
        VehicleDetailDto dto=new VehicleDetailDto();
        return convertEntityToDto(entity,dto);
    }

    public void update(UUID id,VehicleCreateDto dto){
        Vehicle entity=getEntity(id);
        convertDtoToEntity(entity,dto);
        vehicleRepository.save(entity);
    }

    public void delete(UUID id){
        getEntity(id);
        vehicleRepository.deleteById(id);
    }

    public List<VehicleDetailDto> getAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDetailDto> dtos = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            dtos.add(convertEntityToDto(vehicle, new VehicleDetailDto()));
        }
        return dtos;
    }

    public VehicleDetailDto convertEntityToDto(Vehicle entity,VehicleDetailDto dto){
        dto.setId(entity.getId());
        dto.setMerchantId(entity.getMerchantId());
        dto.setBrandId(entity.getBrandId());
        dto.setModelId(entity.getModelId());
        dto.setBodyTypeId(entity.getBodyTypeId());
        dto.setName(entity.getName());
        dto.setYear(entity.getYear());
        dto.setColor(entity.getColor());
        dto.setNumberSits(entity.getNumberSits());
        dto.setIsNew(entity.getIsNew());
        dto.setPrice(entity.getPrice());
        dto.setConditionDuration(entity.getConditionDuration());
        dto.setConditionPrice(entity.getConditionPrice());
        dto.setConditionDurationType(entity.getConditionDurationType());
        dto.setStatus(entity.getStatus());
        return dto;
    }


    public void convertDtoToEntity(Vehicle entity,VehicleCreateDto dto){
        entity.setMerchantId(dto.getMerchantId());
        entity.setBrandId(dto.getBrandId());
        entity.setModelId(dto.getModelId());
        entity.setBodyTypeId(dto.getBodyTypeId());
        entity.setName(dto.getName());
        entity.setYear(dto.getYear());
        entity.setColor(dto.getColor());
        entity.setNumberSits(dto.getNumberSits());
        entity.setIsNew(dto.getIsNew());
        entity.setPrice(dto.getPrice());
        entity.setConditionDuration(dto.getConditionDuration());
        entity.setConditionPrice(dto.getConditionPrice());
        entity.setConditionDurationType(dto.getConditionDurationType());
        entity.setStatus(dto.getStatus());
    }

    public Vehicle getEntity(UUID id) {
        Optional<Vehicle> optional =vehicleRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("vehicle not found");
        }
        return optional.get();
    }
}

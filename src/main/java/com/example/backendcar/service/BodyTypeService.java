package com.example.backendcar.service;

import com.example.backendcar.dto.bodytype.BodyTypeCreateDto;
import com.example.backendcar.dto.bodytype.BodyTypeDetailDto;
import com.example.backendcar.dto.brand.BrandDetailDto;
import com.example.backendcar.exceptions.BadRequest;
import com.example.backendcar.model.BodyType;
import com.example.backendcar.repository.BodyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BodyTypeService {
    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    public void create(BodyTypeCreateDto dto){
        BodyType entity=new BodyType();
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        bodyTypeRepository.save(entity);
    }

    public BodyTypeDetailDto get(UUID id){
        BodyType entity=getEntity(id);
        BodyTypeDetailDto dto=new BodyTypeDetailDto();
        return convertEntityToDto(dto,entity);
    }

    public void update(UUID id,BodyTypeCreateDto dto){
        BodyType entity=getEntity(id);
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        bodyTypeRepository.save(entity);
    }

    public void delete(UUID id){
        getEntity(id);
        bodyTypeRepository.deleteById(id);
    }

    public List<BodyTypeDetailDto> getAll(){
        List<BodyType> bodyTypes=bodyTypeRepository.findAll();
        List<BodyTypeDetailDto> dtos=new ArrayList<>();
        for (BodyType bodyType:bodyTypes) {
            dtos.add(convertEntityToDto(new BodyTypeDetailDto(),bodyType));
        }
        return dtos;
    }

    public BodyTypeDetailDto convertEntityToDto(BodyTypeDetailDto dto,BodyType entity){
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public BodyType getEntity(UUID id){
        Optional<BodyType> optional=bodyTypeRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Body type not found");
        }
        return optional.get();
    }
}

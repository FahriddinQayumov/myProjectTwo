package com.example.backendcar.service;

import com.example.backendcar.dto.model.ModelCreateDto;
import com.example.backendcar.dto.model.ModelDetailDto;
import com.example.backendcar.model.Brand;
import com.example.backendcar.model.Model;
import com.example.backendcar.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public void create(ModelCreateDto dto) {
        Model entity=new Model();
        convertDtoToEntity(entity,dto);
        modelRepository.save(entity);
    }

    public ModelDetailDto get(UUID id) {
        Model entity=getEntity(id);
        ModelDetailDto dto=new ModelDetailDto();
        return convertEntityToDto(entity,dto);
    }

    public void update(UUID id,ModelCreateDto dto){
        Model entity=getEntity(id);
        convertDtoToEntity(entity,dto);
        modelRepository.save(entity);
    }

    public void delete(UUID id){
        getEntity(id);
        modelRepository.deleteById(id);
    }

    public List<ModelDetailDto> getAll(){
        List<Model> models=modelRepository.findAll();
        List<ModelDetailDto> dtos=new ArrayList<>();
        for (Model model:models) {
            dtos.add(convertEntityToDto(model,new ModelDetailDto()));
        }
        return dtos;
    }

    public Model getEntity(UUID id) {
        Optional<Model> optional =modelRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("model not found");
        }
        return optional.get();
    }

    public void convertDtoToEntity(Model entity,ModelCreateDto dto){
        entity.setName(dto.getName());
        entity.setBrandId(dto.getBrandId());
        entity.setStatus(dto.getStatus());
    }

    public ModelDetailDto convertEntityToDto(Model entity,ModelDetailDto dto){
        dto.setId(entity.getId());
        dto.setBrandId(entity.getBrandId());
        dto.setStatus(entity.getStatus());
        dto.setBrand(entity.getBrand());
        return dto;
    }

}

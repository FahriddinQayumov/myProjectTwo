package com.example.backendcar.service;

import com.example.backendcar.dto.brand.BrandCreateDto;
import com.example.backendcar.dto.brand.BrandDetailDto;
import com.example.backendcar.model.Brand;
import com.example.backendcar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public void create(BrandCreateDto dto){
        Brand entity=new Brand();
        convertDtoToEntity(entity,dto);
        brandRepository.save(entity);
    }

    public BrandDetailDto get(UUID id){
        Brand brand=getEntity(id);
        BrandDetailDto dto=new BrandDetailDto();
        return convertEntityToDto(brand,dto);
    }

    public void update(UUID id, BrandCreateDto dto){
        Brand entity=getEntity(id);
        convertDtoToEntity(entity,dto);
        brandRepository.save(entity);
    }

    public void delete(UUID id){
        getEntity(id);
        brandRepository.deleteById(id);
    }

    public List<BrandDetailDto> getAll(){
        List<Brand> brands=brandRepository.findAll();
        List<BrandDetailDto> dtos=new ArrayList<>();
        for (Brand brand:brands) {
            dtos.add(convertEntityToDto(brand,new BrandDetailDto()));
        }
        return dtos;
    }

    public void convertDtoToEntity(Brand entity,BrandCreateDto dto){
          entity.setName(dto.getName());
          entity.setStatus(dto.getStatus());
          entity.setLogo(dto.getLogo());
    }

    public BrandDetailDto convertEntityToDto(Brand entity,BrandDetailDto dto){
        dto.setId(entity.getId());
        dto.setLogo(entity.getLogo());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Brand getEntity(UUID id) {
        Optional<Brand> optional = brandRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("brand not found");
        }
        return optional.get();
    }
}

package com.example.backendcar.service;

import com.example.backendcar.Tools;
import com.example.backendcar.controller.MerchantController;
import com.example.backendcar.dto.merchant.MerchantCreateDto;
import com.example.backendcar.dto.merchant.MerchantDetailDto;
import com.example.backendcar.dto.merchant.MerchantUpdateDto;
import com.example.backendcar.exceptions.BadRequest;
import com.example.backendcar.model.Merchant;
import com.example.backendcar.repository.MerchantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    public void create(MerchantCreateDto dto) {
        Merchant entity = new Merchant();
        convertDtoToEntity(dto, entity);
        LocalDateTime time=dto.getDeletedAt();

        entity.setDeletedAt(LocalDateTime.now());

        merchantRepository.save(entity);
    }

    private void convertDtoToEntity(MerchantCreateDto dto, Merchant entity) {
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        entity.setSlug(dto.getSlug());
        entity.setAddress(dto.getAddress());
        entity.setImageThumb(dto.getImageThumb());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setWebsite(dto.getWebsite());
        entity.setIsFeatured(dto.getIsFeatured());
    }

    public Object get(UUID id) {
        Merchant entity = getEntity(id);
        MerchantDetailDto dto = new MerchantDetailDto();
        return convertEntityDto(entity, dto);
    }

    private MerchantDetailDto convertEntityDto(Merchant entity, MerchantDetailDto dto){
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        dto.setCountry(entity.getCountry());
        dto.setMobile(entity.getMobile());
        dto.setPhone(entity.getPhone());
        dto.setWebsite(entity.getWebsite());
        dto.setImageThumb(entity.getImageThumb());
        dto.setIsFeatured(entity.getIsFeatured());
        dto.setDeletedAt(entity.getDeletedAt());
        return dto;
    }

    public Merchant getEntity(UUID id){
        Optional<Merchant> optional=merchantRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("Merchand topilmadi");
        }
        return optional.get();
    }

    public void update(UUID id, @Valid MerchantUpdateDto dto) {
        Merchant entity = getEntity(id);

        if(dto.getName()!=null) {
            Tools.checkString(dto.getName(), "name");
            entity.setName(dto.getName());
        }if (dto.getAddress()!= null){
            Tools.checkString(dto.getAddress(), "address");
            entity.setAddress(dto.getAddress());
        }if (dto.getCountry()!=null){
            Tools.checkString(dto.getCountry(), "country");
            entity.setCountry(dto.getCountry());
        }if (dto.getPhone()!=null){
            Tools.checkString(dto.getPhone(), "phone");
            entity.setPhone(dto.getPhone());
        }if (dto.getMobile()!=null){
            Tools.checkString(dto.getMobile(), "mobile");
            entity.setMobile(dto.getMobile());
        }if (dto.getEmail()!=null){
            Tools.checkString(dto.getEmail(), "email");
            entity.setEmail(dto.getEmail());
        }if (dto.getWebsite()!=null){
            Tools.checkString(dto.getWebsite(), "website");
            entity.setWebsite(dto.getWebsite());
        }
    }
    
    public List<MerchantDetailDto> getAll(){
        List<Merchant> merchants = merchantRepository.findAll();
        return merchants.stream().map(merchant -> convertEntityDto(merchant, new MerchantDetailDto()))
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        getEntity(id);
        merchantRepository.deleteById(id);
    }
}

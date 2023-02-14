package com.example.backendcar.service;

import com.example.backendcar.Tools;
import com.example.backendcar.dto.user.UserCreateDto;
import com.example.backendcar.dto.user.UserDetailedDto;
import com.example.backendcar.dto.user.UserUpdateDto;
import com.example.backendcar.enums.UserStatus;
import com.example.backendcar.exceptions.BadRequest;
import com.example.backendcar.model.User;
import com.example.backendcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(UserCreateDto dto) {
        User entity=new User();
        convertDtoToEntity(dto,entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setEnable(true);
        userRepository.save(entity);
    }

    private void convertDtoToEntity(UserCreateDto dto, User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirth(dto.getBirth());
        entity.setAvatar(dto.getAvatar());
        entity.setCity(dto.getCity());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setUserTypeId(dto.getUserTypeId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setToken(dto.getToken());
        entity.setPhone(dto.getPhone());
        entity.setBirth(dto.getBirth());
        entity.setAddress2(dto.getAddress2());
        entity.setPostcode(dto.getPostcode());
        entity.setQrCode(dto.getQrCode());
    }
    private UserDetailedDto convertEntityToDto(User entity,UserDetailedDto dto){
        dto.setId(entity.getId());
        dto.setUserTypeId(entity.getUserTypeId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setToken(entity.getToken());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAvatar(entity.getAvatar());
        dto.setPhone(entity.getPhone());
        dto.setBirth(entity.getBirth());
        dto.setAddress(entity.getAddress());
        dto.setAddress2(entity.getAddress2());
        dto.setCity(entity.getCity());
        dto.setPostcode(entity.getPostcode());
        dto.setQrCode(entity.getQrCode());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setEnable(entity.getEnable());
        return dto;
    }


    public void update(UUID id, UserUpdateDto dto) {
        User user=getEntity(id);
        if(dto.getUserTypeId()!=null){
            user.setUserTypeId(dto.getUserTypeId());
        }if(dto.getUsername()!=null){
            Tools.checkString(dto.getUsername(),"username");
            user.setUsername(dto.getUsername());
        }if(dto.getPassword()!=null){
            Tools.checkString(dto.getPassword(), "password");
            user.setPassword(dto.getPassword());
        }if(dto.getEmail()!=null){
            Tools.checkString(dto.getEmail(), "email");
            user.setEmail(dto.getEmail());
        }if(dto.getToken()!=null){
            Tools.checkString(dto.getToken(), "token");
            user.setToken(dto.getToken());
        }if(dto.getFirstName()!=null){
            Tools.checkString(dto.getFirstName(), "first name");
            user.setFirstName(dto.getFirstName());
        }if(dto.getLastName()!=null){
            Tools.checkString(dto.getLastName(),"last name");
            user.setLastName(dto.getLastName());
        }if(dto.getAvatar()!=null){
            Tools.checkString(dto.getAddress(),"avatar");
            user.setAvatar(dto.getAvatar());
        }if(dto.getPhone()!=null){
            Tools.checkString(dto.getPhone(),"phone");
            user.setPhone(dto.getPhone());
        }if(dto.getBirth().isAfter(LocalDate.now())||
                dto.getBirth().isBefore(LocalDate.now().minusYears(100))){
            user.setBirth(dto.getBirth());
        }if(dto.getAddress()!=null){
            Tools.checkString(dto.getAddress() ,"address");
            user.setAddress(dto.getAddress());
        }if(dto.getAddress2()!=null){
            Tools.checkString(dto.getAddress2() ,"address2");
            user.setAddress2(dto.getAddress2());
        }if(dto.getPostcode()!=null){
            Tools.checkString(dto.getPostcode() ,"postcode");
            user.setPostcode(dto.getPostcode());
        }if(dto.getQrCode()!=null){
            Tools.checkString(dto.getQrCode() ,"qr code");
            user.setQrCode(dto.getQrCode());
        }if(dto.getCity()<0){
            user.setCity(dto.getCity());
        }
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    private User getEntity(UUID id){
        Optional<User> optional=userRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        return optional.get();
    }

    public UserDetailedDto get(UUID id) {
        User user =getEntity(id);
        UserDetailedDto dto=new UserDetailedDto();
        convertEntityToDto(user,dto);
        return dto;
    }

    public List<UserDetailedDto> getAll(){
        List<User> userList=userRepository.findAll();
        List<UserDetailedDto> dtoList=new ArrayList<>();
        for (User user :userList) {
            dtoList.add(convertEntityToDto(user,new UserDetailedDto()));
        }
        return dtoList;
    }

}

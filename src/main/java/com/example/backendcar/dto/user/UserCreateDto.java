package com.example.backendcar.dto.user;

import com.example.backendcar.enums.Cities;
import com.example.backendcar.enums.UserStatus;
import com.example.backendcar.model.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserCreateDto {
    private UUID userTypeId;
    @NotBlank(message = "invalid username")
    private String username;
    @NotBlank(message = "invalid password")
    @Size(min=8,max = 30, message = "password szie should be min 8 and max 30 ")
    private String password;
    @Email
    private String email;
    private String token;
    private String firstName;
    private String lastName;
    private String avatar;
    @NotBlank(message =("invalid phone") )
    private String phone;
    private LocalDate birth;
    private String address;
    private String address2;
    private Integer city;
    private String postcode;
    private String qrCode;
}

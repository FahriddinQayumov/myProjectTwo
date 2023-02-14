package com.example.backendcar.dto.user;

import com.example.backendcar.enums.Cities;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class UserUpdateDto {
    private UUID userTypeId;
    private String username;
    @Size(min=8,max = 30, message = "password size should be min 8 and max 30 ")
    private String password;
    @Email
    private String email;
    private String token;
    private String firstName;
    private String lastName;
    private String avatar;
    private String phone;
    private LocalDate birth;
    private String address;
    private String address2;
    private Integer city;
    private String postcode;
    private String qrCode;
}

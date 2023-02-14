package com.example.backendcar.dto.merchant;

import com.example.backendcar.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MerchantUpdateDto {

    private String name;
    @Column(name = ("image_thumb"))
    private String imageThumb;
    @Column(name = ("is_featured"))
    private Boolean isFeatured;
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String address;
    private String country;
    private MerchantStatus status;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

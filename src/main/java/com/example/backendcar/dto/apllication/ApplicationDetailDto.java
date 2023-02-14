package com.example.backendcar.dto.apllication;

import com.example.backendcar.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
@Getter
@Setter
public class ApplicationDetailDto {
   private UUID id;

    private UUID applicationTypeId;
    private ApplicationType applicationType;

    private UUID userId;
    User user;

    private UUID merchanId;
    private Merchant merchant;

    private UUID vehicleId;
    private Vehicle vehicle;

    private Double price;
    private Integer conditionDurationType;
    private Integer conditionDuration;
    private Double conditionPrice;
    private UUID processStatusId;
    private ProcessStatus processStatus;
}

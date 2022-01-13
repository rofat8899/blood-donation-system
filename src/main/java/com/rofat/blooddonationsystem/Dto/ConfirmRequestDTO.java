package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConfirmRequestDTO {
    private LocalDateTime confirmOn;
    private String confirmBy;
    private String bloodId;
    private String bloodType;
    private String bloodSeeker;
    public ConfirmRequestDTO(BloodDonationEntity bloodDonationEntity, BloodRequestEntity bloodRequestEntity, String confirmBy){
        this.confirmOn = LocalDateTime.now();
        this.confirmBy = confirmBy;
        this.bloodId = bloodDonationEntity.getIdAsString();
        this.bloodType = bloodRequestEntity.getRequestBloodType();
        this.bloodSeeker = bloodRequestEntity.getRequestEmail();
    }
}

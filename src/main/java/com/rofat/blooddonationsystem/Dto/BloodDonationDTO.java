package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BloodDonationDTO {
    private LocalDateTime donatedDate;
    private String donorEmail;
    private String status;
    private String remark;
    public BloodDonationDTO(BloodDonationEntity bloodDonationEntity){
        this.donatedDate = bloodDonationEntity.getDonatedDate();
        this.donorEmail = bloodDonationEntity.getDonorEmail();
        this.status = bloodDonationEntity.getStatus();
        this.remark = bloodDonationEntity.getRemark();
    }
}

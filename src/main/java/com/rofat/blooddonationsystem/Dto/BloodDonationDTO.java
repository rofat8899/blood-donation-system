package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodDonationDTO {
    private String donorEmail;
    private String status;
    private String remark;
    public BloodDonationDTO(BloodDonationEntity bloodDonationEntity){
        this.donorEmail = bloodDonationEntity.getDonorEmail();
        this.status = bloodDonationEntity.getStatus();
        this.remark = bloodDonationEntity.getRemark();
    }
}

package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BloodRequestDTO {
    private String requestEmail;
    private LocalDateTime requestDate;
    private String closeDate;
    private String requestBloodType;
    private String bloodReceviedId;
    private LocalDateTime bloodReceivedDate;
    private String donorEmail;
    private LocalDateTime donorSetDate;
    private String priorityStatus;
    private String requestStatus;
    private String remark;
    public BloodRequestDTO(BloodRequestEntity bloodRequestEntity){
        this.requestEmail = bloodRequestEntity.getRequestEmail();
        this.requestDate = bloodRequestEntity.getRequestDate();
        this.closeDate = bloodRequestEntity.getCloseDate();
        this.requestBloodType = bloodRequestEntity.getRequestBloodType();
        this.bloodReceviedId = bloodRequestEntity.getBloodReceviedId();
        this.bloodReceivedDate = bloodRequestEntity.getBloodReceivedDate();
        this.donorSetDate = bloodRequestEntity.getDonorSetDate();
        this.donorEmail = bloodRequestEntity.getDonorEmail();

        this.priorityStatus = bloodRequestEntity.getPriorityStatus();
        this.requestStatus = bloodRequestEntity.getRequestStatus();
        this.remark = bloodRequestEntity.getRemark();
    }
}

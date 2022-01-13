package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.UserDetailEntity;

public class HospitalDetailDTO extends UserDetailDTO{
    public HospitalDetailDTO(UserDetailEntity userDetailEntity) {
        super(userDetailEntity);
    }
    private String testing;
}

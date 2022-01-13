package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.UserContactEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserContactDTO {
    private String phoneNumber;
    private String email;
    private String facebook_telegram;
    public UserContactDTO(UserContactEntity userContactEntity){
        this.phoneNumber=userContactEntity.getPhoneNumber();
        this.email=userContactEntity.getEmail();
        this.facebook_telegram = userContactEntity.getFacebook_telegram();
    }
}

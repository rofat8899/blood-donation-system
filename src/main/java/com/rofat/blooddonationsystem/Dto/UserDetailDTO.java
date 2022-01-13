package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.UserAddressEntity;
import com.rofat.blooddonationsystem.Entity.UserContactEntity;
import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDTO {
    private String email;
    private String name;
    private String gender;
    private String age;
    private String bloodType;
    private String usertype;

    private UserAddressEntity address;
    private UserContactEntity contact;
    public UserDetailDTO(UserDetailEntity userDetailEntity){
        this.email = userDetailEntity.getEmail();
        this.name = userDetailEntity.getName();
        this.gender = userDetailEntity.getGender();
        this.age = userDetailEntity.getAge();
        this.bloodType = userDetailEntity.getBloodType();
        this.usertype = userDetailEntity.getUsertype();
    }
}

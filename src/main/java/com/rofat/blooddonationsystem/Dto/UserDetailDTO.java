package com.rofat.blooddonationsystem.Dto;

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
    private String userType;

    private UserAddressDTO address;
    private UserContactDTO contact;
    public UserDetailDTO(UserDetailEntity userDetailEntity){
        System.out.println(userDetailEntity.toString());
        this.email = userDetailEntity.getEmail();
        this.name = userDetailEntity.getName();
        this.gender = userDetailEntity.getGender();
        this.age = userDetailEntity.getAge();
        this.bloodType = userDetailEntity.getBloodType();
        this.userType = userDetailEntity.getUserType();
        this.address = new UserAddressDTO(userDetailEntity.getAddress());
        this.contact = new UserContactDTO(userDetailEntity.getContact());
    }
}

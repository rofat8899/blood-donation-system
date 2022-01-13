package com.rofat.blooddonationsystem.Dto;

import com.rofat.blooddonationsystem.Entity.UserAddressEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressDTO {
    private String streetNumber;
    private String village;
    private String commune;
    private String district;
    private String province;

    public UserAddressDTO(UserAddressEntity userAddressEntity) {
        this.village = userAddressEntity.getVillage();
        this.commune = userAddressEntity.getCommune();
        this.district = userAddressEntity.getDistrict();
        this.province = userAddressEntity.getProvince();
        this.streetNumber = userAddressEntity.getStreetNumber();
    }
}

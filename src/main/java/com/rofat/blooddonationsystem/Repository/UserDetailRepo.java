package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Dto.UserDetailDTO;
import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailRepo extends JpaRepository<UserDetailEntity,Integer> {
    UserDetailEntity findByEmail(String email);
    UserDetailEntity findByNameAndUserType(String name,String type);
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndBloodType(String email,String bloodType);
    Boolean existsByEmailAndPasswordAndUserType(String email,String password,String userType);
    Boolean existsByEmailAndPassword(String email,String password);
    List<UserDetailDTO> findByUserType(String userType);
}

package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<UserDetailEntity,Integer> {
    UserDetailEntity findByEmail(String email);
    UserDetailEntity findByNameAndUserType(String name,String type);
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndBloodType(String email,String bloodType);
    Boolean existsByEmailAndPasswordAndUserType(String email,String password,String userType);
    Boolean existsByEmailAndPassword(String email,String password);
}

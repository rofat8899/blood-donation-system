package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<UserDetailEntity,Integer> {
    UserDetailEntity findByEmail(String email);
    UserDetailEntity findByEmailAndPassword(String email,String password);
    Boolean findByEmailAndBloodType(String email,String bloodType);
}

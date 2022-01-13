package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRequestRepo extends JpaRepository<BloodRequestEntity,Integer> {
    BloodRequestEntity findByRequestEmail(String email);
    List<BloodRequestEntity> findAllByRequestStatus(String status);
}

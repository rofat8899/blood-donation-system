package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepo extends JpaRepository<BloodRequestEntity,Integer> {
    BloodRequestEntity findByRequestEmail(String email);
}

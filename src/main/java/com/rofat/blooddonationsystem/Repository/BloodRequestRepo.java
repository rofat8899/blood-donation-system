package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepo extends JpaRepository<BloodDonationEntity,Integer> {
}

package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodDonationRepo extends JpaRepository<BloodDonationEntity,Integer> {
    BloodDonationEntity findByDonorEmail(String email);
}

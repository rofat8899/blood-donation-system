package com.rofat.blooddonationsystem.Repository;

import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodDonationRepo extends JpaRepository<BloodDonationEntity,Integer> {
    List<BloodDonationEntity> findByDonorEmail(String email);
    List<BloodDonationEntity> findAllByStatus(String status);
    List<BloodDonationEntity> findAllByStatusAndDonatedAt(String status,String donatedAt);
//    List<BloodDonationEntity> findByStatus(String status);
    List<BloodDonationEntity> findAllByDonatedAt(String status);
}

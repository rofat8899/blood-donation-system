package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.BloodDonationDTO;
import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import com.rofat.blooddonationsystem.Repository.BloodDonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodDonationService {
    @Autowired
    private BloodDonationRepo bloodDonationRepo;

    public List<BloodDonationDTO> getAllBloodDonation() {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAll())
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }

    public BloodDonationDTO getBloodDonationByEmail(String email) {
        return new BloodDonationDTO(bloodDonationRepo.findByDonorEmail(email));
    }

    public BloodDonationDTO addBloodDonation(BloodDonationEntity bloodDonationEntity) {
        return new BloodDonationDTO(bloodDonationRepo.save(bloodDonationEntity));
    }
}

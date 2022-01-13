package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.BloodRequestDTO;
import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import com.rofat.blooddonationsystem.Repository.BloodRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestService {
    @Autowired
    private BloodRequestRepo bloodRequestRepo;

    public List<BloodRequestDTO> getAllBloodRequest() {
        List<BloodRequestDTO> bloodRequestDTO = new ArrayList<>();
        for(BloodRequestEntity each:bloodRequestRepo.findAll())
        {
            bloodRequestDTO.add(new BloodRequestDTO(each));
        }
        return bloodRequestDTO;
    }

    public BloodRequestDTO getBloodRequestByEmail(String email) {
        return new BloodRequestDTO(bloodRequestRepo.findByRequestEmail(email));
    }

    public BloodRequestDTO addBloodRequest(BloodRequestEntity bloodRequestEntity) {
        return new BloodRequestDTO(bloodRequestRepo.save(bloodRequestEntity));
    }
}

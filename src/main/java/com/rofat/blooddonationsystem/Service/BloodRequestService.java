package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.BloodRequestDTO;
import com.rofat.blooddonationsystem.Dto.ResponseMessage;
import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import com.rofat.blooddonationsystem.Repository.BloodRequestRepo;
import com.rofat.blooddonationsystem.Repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestService {
    @Autowired
    private BloodRequestRepo bloodRequestRepo;
    @Autowired
    private UserDetailRepo userDetailRepo;

    public List<BloodRequestDTO> getAllBloodRequest() {
        List<BloodRequestDTO> bloodRequestDTO = new ArrayList<>();
        for(BloodRequestEntity each:bloodRequestRepo.findAll())
        {
            bloodRequestDTO.add(new BloodRequestDTO(each));
        }
        return bloodRequestDTO;
    }

    public List<BloodRequestDTO> getBloodRequestByEmail(String email) {
        List<BloodRequestDTO> bloodRequestDTO = new ArrayList<>();
        for(BloodRequestEntity each:bloodRequestRepo.findBloodRequestEntityByRequestEmail(email))
        {
            bloodRequestDTO.add(new BloodRequestDTO(each));
        }
        return bloodRequestDTO;
    }

    public Object addBloodRequest(BloodRequestEntity bloodRequestEntity) {
        if(userDetailRepo.existsByEmail(bloodRequestEntity.getRequestEmail()))
        {
            bloodRequestEntity.setRequestDate(LocalDateTime.now());
            bloodRequestEntity.setRequestStatus("PENDING");
            return new BloodRequestDTO(bloodRequestRepo.save(bloodRequestEntity));
        }
        else
        {
            return new ResponseMessage("Requested User is not exists");
        }
    }

    public List<BloodRequestDTO> getAllBloodPendingRequest() {
        List<BloodRequestDTO> bloodRequestDTO = new ArrayList<>();
        for(BloodRequestEntity each:bloodRequestRepo.findAllByRequestStatus("PENDING"))
        {
            bloodRequestDTO.add(new BloodRequestDTO(each));
        }
        return bloodRequestDTO;
    }
}

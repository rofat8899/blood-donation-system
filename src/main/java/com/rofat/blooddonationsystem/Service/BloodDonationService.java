package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.BloodDonationDTO;
import com.rofat.blooddonationsystem.Dto.ResponseMessage;
import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import com.rofat.blooddonationsystem.Repository.BloodDonationRepo;
import com.rofat.blooddonationsystem.Repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BloodDonationService {
    @Autowired
    private BloodDonationRepo bloodDonationRepo;
    @Autowired
    private UserDetailRepo userDetailRepo;

    public List<BloodDonationDTO> getAllBloodDonation() {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAll())
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }

    public List<BloodDonationDTO> getBloodDonationByEmail(String email) {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findByDonorEmail(email))
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }

    public Object addBloodDonation(BloodDonationEntity bloodDonationEntity,String hospital) {
        if(userDetailRepo.existsByEmail(bloodDonationEntity.getDonorEmail()))
        {
            bloodDonationEntity.setDonatedAt(userDetailRepo.findByNameAndUserType(hospital,"HOSPITAL").getName());
            bloodDonationEntity.setDonatedDate(LocalDateTime.now());
            bloodDonationEntity.setStatus("AVAILABLE");
            return new BloodDonationDTO(bloodDonationRepo.save(bloodDonationEntity));
        }
        return new ResponseMessage("User is not existed");
    }

    public List<BloodDonationDTO> getAllBloodAvailableDonation() {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAllByStatus("AVAILABLE"))
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }

    public List<BloodDonationDTO> getAllBloodDonationByHospital(String hospital) {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAllByDonatedAt(hospital))
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }

    public List<BloodDonationDTO> getAllBloodAvailableDonationByHospital(String hospital) {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAllByStatusAndDonatedAt("AVAILABLE",hospital))
        {
            bloodDonationDTO.add(new BloodDonationDTO(each));
        }
        return bloodDonationDTO;
    }
}

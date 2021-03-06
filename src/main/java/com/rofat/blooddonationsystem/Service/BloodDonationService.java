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

    public Object addBloodDonation(String email,String hospital) {
        BloodDonationEntity bloodDonationEntity = bloodDonationRepo.findByDonorEmailAndStatus(email,"PENDING");
        if(userDetailRepo.existsByEmail(bloodDonationEntity.getDonorEmail()))
        {
            bloodDonationEntity.setDonatedAt(userDetailRepo.findByNameAndUserType(hospital,"HOSPITAL").getName());
            bloodDonationEntity.setDonatedDate(LocalDateTime.now());
            bloodDonationEntity.setStatus("AVAILABLE");
            return new BloodDonationDTO(bloodDonationRepo.save(bloodDonationEntity));
        }
        return new ResponseMessage("User is not existed");
    }

    public Object addPendingBloodDonation(BloodDonationEntity bloodDonationEntity) {
        if(userDetailRepo.existsByEmail(bloodDonationEntity.getDonorEmail()))
        {
            bloodDonationEntity.setStatus("PENDING");
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

    public List<BloodDonationDTO> getAllBloodPendingDonation() {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAllByStatus("PENDING"))
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

    public List<BloodDonationDTO> getAllPendingBloodDonationByBloodType(String bloodType) {
        List<BloodDonationDTO> bloodDonationDTO = new ArrayList<>();
        for(BloodDonationEntity each:bloodDonationRepo.findAllByStatus("PENDING"))
        {
            if(userDetailRepo.findByEmail(each.getDonorEmail()).getBloodType().contains(bloodType)){
                bloodDonationDTO.add(new BloodDonationDTO(each));
            }
        }
        return bloodDonationDTO;
    }
}

package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.ConfirmRequestDTO;
import com.rofat.blooddonationsystem.Dto.ResponseMessage;
import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import com.rofat.blooddonationsystem.Repository.BloodDonationRepo;
import com.rofat.blooddonationsystem.Repository.BloodRequestRepo;
import com.rofat.blooddonationsystem.Repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ConfirmationRequestService {
    @Autowired
    private BloodDonationRepo bloodDonationRepo;
    @Autowired
    private BloodRequestRepo bloodRequestRepo;
    @Autowired
    private UserDetailRepo userDetailRepo;

    public Object acceptRequest(String req_email,Map<String, Object> obj) {
        if(isHospital(obj)){
            BloodRequestEntity bloodRequest = bloodRequestRepo.findByRequestEmail(req_email);
            for(BloodDonationEntity each :bloodDonationRepo.findAllByStatus("AVAILABLE"))
            {
                if(userDetailRepo.existsByEmailAndBloodType(each.getDonorEmail(),bloodRequest.getRequestBloodType())){
                    bloodRequest.setBloodReceviedId(each.getIdAsString());
                    bloodRequest.setBloodReceivedDate(LocalDateTime.now());
                    bloodRequest.setRequestStatus("ACCEPTED");
                    bloodRequestRepo.save(bloodRequest);

                    each.setStatus("NOT AVAILABLE");
                    bloodDonationRepo.save(each);
                    return new ConfirmRequestDTO(each,bloodRequest,(String) obj.get("email"));
                }
            }
        }
        else{
            return new ResponseMessage("YOU HAVE NO RIGHT FOR THIS ACTION");
        }
        return null;
    }

    private boolean isHospital(Map<String, Object> obj)
    {
        String UserEmail = (String) obj.get("email");
        String UserPassword = (String) obj.get("password");
        return userDetailRepo.existsByEmailAndPasswordAndUserType(UserEmail,UserPassword,"HOSPITAL");
    }
}

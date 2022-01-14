package com.rofat.blooddonationsystem.Controller;

import com.rofat.blooddonationsystem.Dto.BloodDonationDTO;
import com.rofat.blooddonationsystem.Dto.BloodRequestDTO;
import com.rofat.blooddonationsystem.Service.BloodDonationService;
import com.rofat.blooddonationsystem.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blood")
public class BloodController {
    @Autowired
    private BloodDonationService bloodDonationService;
    @Autowired
    private BloodRequestService bloodRequestService;

    @GetMapping("/donation")
    public List<BloodDonationDTO> getAllBloodDonation(){
        return bloodDonationService.getAllBloodDonation();
    }

    @GetMapping("/donation/{hospital}")
    public List<BloodDonationDTO> getAllBloodDonationByHospital(@PathVariable("hospital") String hospital){
        return bloodDonationService.getAllBloodDonationByHospital(hospital);
    }

    @GetMapping("/donation/available")
    public List<BloodDonationDTO> getAllAvailableBloodDonation(){
        return bloodDonationService.getAllBloodAvailableDonation();
    }

    @GetMapping("/request")
    public List<BloodRequestDTO> getAllBloodRequest(){
        return bloodRequestService.getAllBloodRequest();
    }

    @GetMapping("/request/pending")
    public List<BloodRequestDTO> getAllBloodPendingRequest()
    {
        return bloodRequestService.getAllBloodPendingRequest();
    }
    
}

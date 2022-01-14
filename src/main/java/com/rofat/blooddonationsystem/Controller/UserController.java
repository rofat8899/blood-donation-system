package com.rofat.blooddonationsystem.Controller;

import com.rofat.blooddonationsystem.Dto.BloodDonationDTO;
import com.rofat.blooddonationsystem.Dto.BloodRequestDTO;
import com.rofat.blooddonationsystem.Dto.ConfirmRequestDTO;
import com.rofat.blooddonationsystem.Dto.UserDetailDTO;
import com.rofat.blooddonationsystem.Entity.BloodDonationEntity;
import com.rofat.blooddonationsystem.Entity.BloodRequestEntity;
import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import com.rofat.blooddonationsystem.Service.BloodDonationService;
import com.rofat.blooddonationsystem.Service.BloodRequestService;
import com.rofat.blooddonationsystem.Service.ConfirmationRequestService;
import com.rofat.blooddonationsystem.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private ConfirmationRequestService confirmationRequestService;
    @Autowired
    private BloodDonationService bloodDonationService;
    @Autowired
    private BloodRequestService bloodRequestService;

    @GetMapping("")
    public List<UserDetailDTO> getAllUserDetail(){
        return userDetailService.getAllUserDetail();
    }

    @GetMapping("/{email}")
    public UserDetailDTO getUserDetailByEmail(@PathVariable("email") String email){
        return userDetailService.getUserDetailByEmail(email);
    }

    @PostMapping("")
    public UserDetailDTO addUserDetail(@RequestBody UserDetailEntity userDetailEntity)
    {
        return userDetailService.addUserDetail(userDetailEntity);
    }

    @PutMapping("/confirm/{email}")
    public ConfirmRequestDTO confirmBloodRequest(@PathVariable("email") String email, @RequestBody Map<String,Object> obj)
    {
        return confirmationRequestService.acceptRequest(email,obj);
    }

    @PostMapping("/request")
    public BloodRequestDTO addBloodRequest(@RequestBody BloodRequestEntity bloodRequestEntity){
        return bloodRequestService.addBloodRequest(bloodRequestEntity);
    }

    @GetMapping("/request/{email}")
    public List<BloodRequestDTO> getBloodRequestByEmail(@PathVariable("email") String email){
        return bloodRequestService.getBloodRequestByEmail(email);
    }

    @PostMapping("/donation")
    public Object addBloodDonation(@RequestBody BloodDonationEntity bloodDonationEntity){
        return bloodDonationService.addBloodDonation(bloodDonationEntity);
    }

    @GetMapping("/donation/{email}")
    public List<BloodDonationDTO> getBloodDonationByEmail(@PathVariable("email") String email){
        return bloodDonationService.getBloodDonationByEmail(email);
    }

    @GetMapping("/login")
    public Object login(@RequestBody Map<String,Object> obj){
        return userDetailService.login(obj);
    }
}

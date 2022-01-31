package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.BloodRequestDTO;
import com.rofat.blooddonationsystem.Dto.InboxDTO;
import com.rofat.blooddonationsystem.Dto.ResponseMessage;
import com.rofat.blooddonationsystem.Dto.UserDetailDTO;
import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import com.rofat.blooddonationsystem.Repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepo userDetailRepo;
    @Autowired
    private BloodRequestService bloodRequestService;

    public List<UserDetailDTO> getAllUserDetail() {
        List<UserDetailDTO> userDetailDTO = new ArrayList<>();
        for (UserDetailEntity each : userDetailRepo.findAll()) {
            userDetailDTO.add(new UserDetailDTO(each));
        }
        return userDetailDTO;
    }

    public UserDetailDTO getUserDetailByEmail(String email) {
        return new UserDetailDTO(userDetailRepo.findByEmail(email));
    }

    public UserDetailDTO addUserDetail(UserDetailEntity userDetailEntity) {
        return new UserDetailDTO(userDetailRepo.save(userDetailEntity));
    }

    public Object login(Map<String, Object> obj) {
        String email = (String) obj.get("email");
        String password = (String) obj.get("password");
        if (userDetailRepo.existsByEmailAndPassword(email, password)) {
            return new ResponseMessage("Successful login");
        } else {
            return new ResponseMessage("Failed to login");
        }
    }

    public List<InboxDTO> getInboxbyEmail(String email) {
        List<InboxDTO> inboxDTO = new ArrayList<>();
        List<BloodRequestDTO> bloodRequestDTOList = bloodRequestService.getBloodRequestByEmail(email);
        UserDetailDTO userDetailDTO = getUserDetailByEmail(email);
        String header, date, body;
        for (BloodRequestDTO each : bloodRequestDTOList) {
            if ("ACCEPTED".equals(each.getRequestStatus())) {
                UserDetailDTO donorDetailDTO = getUserDetailByEmail(each.getDonorEmail());
                header = "Congratulations," + userDetailDTO.getName() + ".";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                date = each.getDonorSetDate().format(formatter);
                body = "<html>Your request for blood type A donation has been accepted by " + donorDetailDTO.getName() +
                        "<br>" +
                        "We have listed all the needed information of you donor for you," +
                        "please click on See Detail button to see the detail information.</html>";
                inboxDTO.add(new InboxDTO(header, date, body));
            }
            if ("PENDING".equals(each.getRequestStatus()) && userDetailDTO.getBloodType().equals(each.getRequestBloodType())) {

                UserDetailDTO requestUserDetailDTO = getUserDetailByEmail(each.getRequestEmail());
                header = "Dear," + userDetailDTO.getName() + ".";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                date = each.getRequestDate().format(formatter);
                body = "<html>"+requestUserDetailDTO.getName()+" is urgently looking for donation of "+each.getRequestBloodType()+" blood,"+
                        "we find out that the required <>br blood is the same type of yours, hence we let you hear" +
                        "this precious opportunity priority to save someone's life. <br>Give the gift of live, donate blood.</html>";
                inboxDTO.add(new InboxDTO(header, date, body));
            }
        }
        return inboxDTO;
    }

    public List<UserDetailDTO> getAllHospital() {
        List<UserDetailDTO> userDetailDTO = new ArrayList<>();
        for (UserDetailEntity each : userDetailRepo.findAllByUserType("HOSPITAL")) {
            userDetailDTO.add(new UserDetailDTO(each));
        }
        return userDetailDTO;
    }
}

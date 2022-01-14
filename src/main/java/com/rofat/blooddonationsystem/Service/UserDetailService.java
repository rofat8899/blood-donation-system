package com.rofat.blooddonationsystem.Service;

import com.rofat.blooddonationsystem.Dto.ResponseMessage;
import com.rofat.blooddonationsystem.Dto.UserDetailDTO;
import com.rofat.blooddonationsystem.Entity.UserDetailEntity;
import com.rofat.blooddonationsystem.Repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepo userDetailRepo;

    public List<UserDetailDTO> getAllUserDetail() {
        List<UserDetailDTO> userDetailDTO = new ArrayList<>();
        for(UserDetailEntity each:userDetailRepo.findAll())
        {
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
        if(userDetailRepo.existsByEmailAndPassword(email,password))
        {
            return new ResponseMessage("Successful login");
        }
        else {
            return new ResponseMessage("Failed to login");
        }
    }
}

package com.rofat.blooddonationsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {
    private String message;
    public ResponseMessage(String msg){
        this.message = msg;
    }
}

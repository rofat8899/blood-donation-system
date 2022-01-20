package com.rofat.blooddonationsystem.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InboxDTO {

    private String header;
    private String date;
    private String Body;
    public InboxDTO(String header,String date, String body){
        this.header = header;
        this.date = date;
        this.Body = body;
    }
}

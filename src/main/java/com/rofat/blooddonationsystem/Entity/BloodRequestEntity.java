package com.rofat.blooddonationsystem.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "BLOOD_REQUEST")
public class BloodRequestEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="REQUEST_EMAIL")
    private String requestEmail;
    @Column(name="REQUEST_DATE")
    private LocalDateTime requestDate;
    @Column(name="CLOSE_DATE")
    private LocalDateTime closeDate;
    @Column(name="REQUEST_BLOOD_TYPE")
    private String requestBloodType;
    @Column(name="BLOOD_RECEIVED_ID")
    private String bloodReceviedId;
    @Column(name="BLOOD_RECEIVED_DATE")
    private LocalDateTime bloodReceivedDate;
    @Column(name="PRIORITY_STATUS")
    private String priorityStatus;
    @Column(name="REQUEST_STATUS")
    private String requestStatus;
    @Column(name="REMARK")
    private String remark;


}

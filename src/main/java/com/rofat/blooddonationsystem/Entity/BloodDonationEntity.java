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
@Table(name = "BLOOD_DONATION")
public class BloodDonationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="DONATED_DATE")
    private LocalDateTime donatedDate;
    @Column(name="DONOR_EMAIL")
    private String donorEmail;
    @Column(name="STATUS")
    private String status;
    @Column(name="REMARK")
    private String remark;

}

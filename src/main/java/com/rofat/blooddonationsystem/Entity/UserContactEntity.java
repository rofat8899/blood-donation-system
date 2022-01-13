package com.rofat.blooddonationsystem.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER_CONTACT")
public class UserContactEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    @Column(name="EMAIL")
    private String email;
    @Column(name="FACEBOOK_TELEGRAM")
    private String facebook_telegram;
}

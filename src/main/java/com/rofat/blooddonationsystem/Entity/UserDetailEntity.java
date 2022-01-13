package com.rofat.blooddonationsystem.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER")
public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="NAME")
    private String name;
    @Column(name="GENDER")
    private String gender;
    @Column(name="AGE")
    private String age;
    @Column(name="BLOOD_TYPE")
    private String bloodType;
    @Column(name="USER_TYPE")
    private String userType;
    @OneToOne(cascade = CascadeType.ALL)
    private UserAddressEntity address;
    @OneToOne(cascade = CascadeType.ALL)
    private UserContactEntity contact;

}

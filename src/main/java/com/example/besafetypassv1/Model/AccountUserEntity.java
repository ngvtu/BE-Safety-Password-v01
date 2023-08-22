package com.example.besafetypassv1.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "account_user")
public class AccountUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    private String email;
    private String address;


}

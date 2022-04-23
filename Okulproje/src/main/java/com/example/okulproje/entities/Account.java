package com.example.okulproje.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Account  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int AccountId;
    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;










}

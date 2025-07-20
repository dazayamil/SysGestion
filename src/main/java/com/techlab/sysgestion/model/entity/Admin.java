package com.techlab.sysgestion.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@Getter
public class Admin extends User{
    private String password;

    public Admin(String name, String lastName, String email, String password){
        super(name, lastName, email);
        this.password = password;
    }
}

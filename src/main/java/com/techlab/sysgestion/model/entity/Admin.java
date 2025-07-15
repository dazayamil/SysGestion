package com.techlab.sysgestion.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@NoArgsConstructor
public class Admin extends User{
    private String password;
    private String email;

    public Admin(String name, String lastName, String password, String email){
        super(name, lastName);
        this.password = password;
        this.email = email;
    }
}

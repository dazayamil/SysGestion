package com.techlab.sysgestion.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String lastName;
    private String email;

    public User(String name, String lastName, String email){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}

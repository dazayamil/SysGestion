package com.techlab.sysgestion.model.entity;

import javax.swing.plaf.SeparatorUI;

public class Client extends User{
    private String phone;

    public Client(String name, String lastName, String phone){
        super(name, lastName);
        this.phone = phone;
    }
}

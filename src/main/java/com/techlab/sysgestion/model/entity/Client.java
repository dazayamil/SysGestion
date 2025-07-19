package com.techlab.sysgestion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

import javax.swing.plaf.SeparatorUI;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client")
@Getter
public class Client extends User{
    private String phone;

    public Client(String name, String lastName, String phone){
        super(name, lastName);
        this.phone = phone;
    }

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
}

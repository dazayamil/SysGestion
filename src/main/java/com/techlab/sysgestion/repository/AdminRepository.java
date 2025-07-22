package com.techlab.sysgestion.repository;

import com.techlab.sysgestion.model.entity.Admin;
import com.techlab.sysgestion.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Integer>{
    Optional<Admin> findByEmail(String email);
}

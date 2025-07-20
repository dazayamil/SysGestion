package com.techlab.sysgestion.repository;

import com.techlab.sysgestion.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

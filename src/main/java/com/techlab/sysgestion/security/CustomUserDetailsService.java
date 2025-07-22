package com.techlab.sysgestion.security;

import com.techlab.sysgestion.model.entity.Admin;
import com.techlab.sysgestion.repository.AdminRepository;
import com.techlab.sysgestion.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        Admin admin = adminRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Admin not found: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(admin.getEmail())
                .password("{noop}admin1234")
                .roles("ADMIN")
                .build();
    }
}

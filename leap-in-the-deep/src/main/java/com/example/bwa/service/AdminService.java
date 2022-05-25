package com.example.bwa.service;

import com.example.bwa.repo.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    @Autowired
    private final AdminRepository adminRepository;
}

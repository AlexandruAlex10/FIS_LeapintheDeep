package com.example.bwa.controller;

import com.example.bwa.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;
}

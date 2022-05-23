package com.example.bwa.service;

import com.example.bwa.repo.WishlistRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishlistService {
    @Autowired
    private final WishlistRepository wishlistRepository;
    
}

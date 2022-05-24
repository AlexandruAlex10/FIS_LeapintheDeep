package com.example.bwa.service;

import com.example.bwa.repo.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;
    
}

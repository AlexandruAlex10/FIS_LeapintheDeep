package com.example.bwa.controller;

import com.example.bwa.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/reviews")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;
    
}

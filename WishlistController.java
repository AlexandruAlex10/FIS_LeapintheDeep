package com.example.bwa.controller;

import com.example.bwa.service.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "#wishlist")
public class WishlistController {
    @Autowired
    private final WishlistService wishlistService;
    
}

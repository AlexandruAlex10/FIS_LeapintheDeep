package com.example.bwa.controller;

import com.example.bwa.service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "#favourite")
public class FavouriteController {
    @Autowired
    private final FavouriteService favouriteService;
}

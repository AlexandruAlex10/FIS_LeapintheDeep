package com.example.bwa.service;

import com.example.bwa.repo.FavouriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FavouriteService {
    @Autowired
    private final FavouriteRepository favouriteRepository;

}

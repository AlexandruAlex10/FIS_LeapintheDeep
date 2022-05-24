package com.example.bwa.controller;

import com.example.bwa.service.FavouriteService;
import com.example.bwa.user.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "#favourite")
public class FavouriteController {
    @Autowired
    private final FavouriteService favouriteService;

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(this.favouriteService.getBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id) {
        this.favouriteService.deleteBookById(id);
        return HttpStatus.OK;
    }
}

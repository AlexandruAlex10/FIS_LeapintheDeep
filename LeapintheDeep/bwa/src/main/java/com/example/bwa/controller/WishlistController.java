package com.example.bwa.controller;

import com.example.bwa.service.WishlistService;
import com.example.bwa.user.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "#wishlist")
public class WishlistController {
    @Autowired
    private final WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(this.wishlistService.getBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id) {
        this.wishlistService.deleteBookById(id);
        return HttpStatus.OK;
    }
}

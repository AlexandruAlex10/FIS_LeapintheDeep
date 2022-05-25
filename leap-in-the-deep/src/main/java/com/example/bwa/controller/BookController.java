package com.example.bwa.controller;

import com.example.bwa.service.BookService;
import com.example.bwa.service.ReviewService;
import com.example.bwa.user.Book;
import com.example.bwa.user.Review;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private final BookService bookService;

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable() Long id){
        return new ResponseEntity(bookService.getBookById(id).get(), HttpStatus.OK);//daca e Optional, pui .get()
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<Book>> getBooksByName(@PathVariable() String name){
        return new ResponseEntity(bookService.getBooksByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getReviews(id), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/newReview")
    public ResponseEntity<?> addReview(@PathVariable Long id, @RequestBody Review review){
        bookService.addReview(id, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

package com.example.bwa.controller;

import com.example.bwa.service.ReviewService;
import com.example.bwa.user.Review;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/reviews")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(){
        return new ResponseEntity<>(this.reviewService.getReviews(), HttpStatus.OK);
    }

    @GetMapping(path = "/{author}")
    public ResponseEntity<List<Review>> getReviewsByAuthor(@PathVariable() String author){
        return new ResponseEntity<>(this.reviewService.getReviewsByAuthor(author), HttpStatus.OK);
    }

    @PostMapping(path = "/thisReview")
    public ResponseEntity<Review> postReview(@RequestBody Review newReview){
        return new ResponseEntity<>(this.reviewService.postReview(newReview), HttpStatus.OK);
    }
}

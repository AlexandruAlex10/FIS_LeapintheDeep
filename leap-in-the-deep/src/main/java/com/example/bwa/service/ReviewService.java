package com.example.bwa.service;

import com.example.bwa.repo.ReviewRepository;
import com.example.bwa.user.Book;
import com.example.bwa.user.Review;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;

    public List<Review> getReviews() {

        List<Review> allReviews = new ArrayList<>();
        this.reviewRepository.findAll().forEach(allReviews::add);
        return allReviews;
    }

    public Review postReview(Review newReview) {
        return this.reviewRepository.save(newReview);
    }

    public List<Review> getReviewsByAuthor(String author) {
        List<Review> allReviews = new ArrayList<>();
        this.reviewRepository.findAll().forEach(allReviews::add);
        List<Review> searchedReviews = new ArrayList<>();
        for(Review review: allReviews){
            if(review.getAuthor().equals(author)){
                searchedReviews.add(review);
            }
        }
        return searchedReviews;
    }
}

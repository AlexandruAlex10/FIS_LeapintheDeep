package com.example.bwa.service;

import com.example.bwa.repo.BookRepository;
import com.example.bwa.repo.ReviewRepository;
import com.example.bwa.user.Book;
import com.example.bwa.user.Review;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final ReviewRepository reviewRepository;

    public Optional<Book> getBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    public List<Book> getBooksByName(String name){
        List<Book> allBooks = new ArrayList<>();
        this.bookRepository.findAll().forEach(allBooks::add);
        List<Book> searchedBooks = new ArrayList<>();
        for(Book book: allBooks){
            if(book.getName().equals(name)){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>();
        this.bookRepository.findAll().forEach(allBooks::add);
        return allBooks;
    }

    public List<Review> getReviews(Long id) {
        Book b = this.getBookById(id).get();
        return b.getReviews();
    }

    public void addReview(Long id, Review review) {
        Book b = this.getBookById(id).get();
        b.addReview(review);
        this.reviewRepository.save(review);
        this.bookRepository.save(b);
    }
}

package com.example.bwa.service;

import com.example.bwa.repo.FavouriteRepository;
import com.example.bwa.user.Book;
import com.example.bwa.user.Favourite;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FavouriteService {
    @Autowired
    private final FavouriteRepository favouriteRepository;

    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>();
        this.favouriteRepository.findAll().forEach(Favourite::getBooks);
        List<Book> searchedBooks = new ArrayList<>();
        for(Book book: allBooks){
            if(book.getReviewCalculated().equals(5) && book.getIsRead()){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    public void deleteBookById(Long id) {
        boolean exists = favouriteRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("book with id " + id + " does not exists!");
        }
        favouriteRepository.deleteById(id);
    }
}
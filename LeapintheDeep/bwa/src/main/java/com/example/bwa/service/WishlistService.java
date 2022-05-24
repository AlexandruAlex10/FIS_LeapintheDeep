package com.example.bwa.service;

import com.example.bwa.repo.WishlistRepository;
import com.example.bwa.user.Book;
import com.example.bwa.user.Wishlist;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WishlistService {
    @Autowired
    private final WishlistRepository wishlistRepository;

    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>();
        this.wishlistRepository.findAll().forEach(Wishlist::getBooks);
        List<Book> searchedBooks = new ArrayList<>();
        for(Book book: allBooks){
            if(!book.getIsRead()){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    public void deleteBookById(Long id) {
       boolean exists = wishlistRepository.existsById(id);
        if(!exists){
           throw new IllegalStateException("book with id " + id + " does not exists!");
       }
        wishlistRepository.deleteById(id);
    }
}

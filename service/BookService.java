package com.example.bwa.service;

import com.example.bwa.repo.BookRepository;
import com.example.bwa.user.Book;
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
}

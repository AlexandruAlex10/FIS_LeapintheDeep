package com.example.bwa.service;

import com.example.bwa.enums.LogInSignUp;
import com.example.bwa.repo.BookRepository;
import com.example.bwa.repo.UserRepository;
import com.example.bwa.user.Book;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BookRepository bookRepository;

    public static String encodePassword(String password){

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword;
    }

    public static String decodePassword(String encodedPassword){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);
        return decodedPassword;
    }

    public LogInSignUp register(User newUser) {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        System.out.println("New Writer: " + newUser);

        for (User w : users) {
            if (w.equals(newUser)) {
                return LogInSignUp.ALREADY_EXISTS;
            }
        }
        newUser.setPassword(encodePassword(newUser.getPassword()));
        this.userRepository.save(newUser);
        return LogInSignUp.SUCCESS;
    }

    public Optional<User> logIn(String username, String password){
        Optional<User> user = this.getUserByUsername(username);
        String p = encodePassword(password);
        if(user.isPresent() && user.get().getUsername().equals(username) && user.get().getPassword().equals(p)){
            return user;
        }
        return Optional.ofNullable(null);
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public List<User> getUsers() {
        List<User> allUsers = new ArrayList<>();
        this.userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public void addNewBook(String username, Book book) {
        User u = this.getUserByUsername(username).get();
        book.setAuthor(username);
        u.addWrittenBook(book);
        this.bookRepository.save(book);
        this.userRepository.save(u);
    }

    public void addWishlist(String username, Book book) {
        User u = this.getUserByUsername(username).get();
        u.addWishlistBook(book);
        this.userRepository.save(u);
    }

    public void addFavourite(String username, Book book) {
        User u = this.getUserByUsername(username).get();
        u.addFavouriteBook(book);
        this.userRepository.save(u);
    }

    public void addWritten(String username, Book book) {
        User u = this.getUserByUsername(username).get();
        u.addWrittenBook(book);
        this.userRepository.save(u);
    }

    public void addRead(String username, Book book) {
        User u = this.getUserByUsername(username).get();
        u.addReadBook(book);
        this.userRepository.save(u);
    }

    public List<Book> getWishlist(String username) {
        User u = this.userRepository.findByUsername(username).get();
        return u.getWishlist();
    }

    public List<Book> getFavourite(String username) {
        User u = this.userRepository.findByUsername(username).get();
        return u.getFavourite();
    }

    public List<Book> getWritten(String username) {
        User u = this.userRepository.findByUsername(username).get();
        return u.getWrittenBooks();
    }

    public List<Book> getRead(String username) {
        User u = this.userRepository.findByUsername(username).get();
        return u.getReadBooks();
    }
}

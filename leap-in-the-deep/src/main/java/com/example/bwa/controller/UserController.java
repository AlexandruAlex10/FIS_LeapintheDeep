package com.example.bwa.controller;

import com.example.bwa.enums.LogInSignUp;
import com.example.bwa.service.UserService;
import com.example.bwa.user.Book;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping()
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<LogInSignUp> register(@Valid @RequestBody User newUser){
        System.out.println(newUser);
        return new ResponseEntity<>(userService.register(newUser), HttpStatus.OK);
    }

    @PostMapping(path = "/log-in")
    public ResponseEntity<User> logIn(@RequestParam String username, @RequestParam String password){
        Optional<User> user = this.userService.logIn(username, password);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable() Long id){
        return new ResponseEntity<>(userService.getUserById(id).get(), HttpStatus.OK);
        //daca e Optional, pui .get()
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUserByEmail(@PathVariable() String name){
        return new ResponseEntity<>(userService.getUserByUsername(name).get(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping(path = "user/{username}/newBook")
    public ResponseEntity<?> addNewBook(@PathVariable String username, @RequestBody Book book){
        userService.addNewBook(username, book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "user/{username}/add-wishlist")
    public ResponseEntity<?> addWishlist(@PathVariable String username, @RequestBody Book book){
        System.out.println(book);
        userService.addWishlist(username, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "user/{username}/add-written")
    public ResponseEntity<?> addWritten(@PathVariable String username, @RequestBody Book book){
        userService.addWritten(username, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "user/{username}/add-read")
    public ResponseEntity<?> addRead(@PathVariable String username, @RequestBody Book book){
        userService.addRead(username, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "user/{username}/add-favourites")
    public ResponseEntity<?> addFavourite(@PathVariable String username, @RequestBody Book book){
        userService.addFavourite(username, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "user/{username}/wishlist")
    public ResponseEntity<List<Book>> getWishlist(@PathVariable String username){
        return new ResponseEntity<>(userService.getWishlist(username), HttpStatus.OK);
    }

    @GetMapping(path = "user/{username}/favourites")
    public ResponseEntity<List<Book>> getFavourite(@PathVariable String username){
        return new ResponseEntity<>(userService.getFavourite(username), HttpStatus.OK);
    }

    @GetMapping(path = "user/{username}/written")
    public ResponseEntity<List<Book>> getWritten(@PathVariable String username){
        return new ResponseEntity<>(userService.getWritten(username), HttpStatus.OK);
    }

    @GetMapping(path = "user/{username}/read")
    public ResponseEntity<List<Book>> getRead(@PathVariable String username){
        return new ResponseEntity<>(userService.getRead(username), HttpStatus.OK);
    }

}

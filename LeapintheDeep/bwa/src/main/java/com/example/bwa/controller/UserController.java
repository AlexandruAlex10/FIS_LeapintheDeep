package com.example.bwa.controller;

import com.example.bwa.enums.LogInSignUp;
import com.example.bwa.service.UserService;
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
    public ResponseEntity<LogInSignUp> logIn(@Valid @RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<>(userService.logIn(user), HttpStatus.OK);
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<LogInSignUp> logOut(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.logOut(user), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable() Long id){
        return new ResponseEntity(userService.getUserById(id).get(), HttpStatus.OK);
        //daca e Optional, pui .get()
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUserByEmail(@PathVariable() String name){
        return new ResponseEntity(userService.getUserByUserName(name).get(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

}

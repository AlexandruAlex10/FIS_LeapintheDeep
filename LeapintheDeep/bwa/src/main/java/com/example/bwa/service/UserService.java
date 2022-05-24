package com.example.bwa.service;

import com.example.bwa.enums.LogInSignUp;
import com.example.bwa.repo.UserRepository;
import com.example.bwa.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public LogInSignUp register(User newUser) {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        System.out.println("New Writer: " + newUser);

        for (User w : users) {
            if (w.equals(newUser)) {
                return LogInSignUp.ALREADY_EXISTS;
            }
        }
        this.userRepository.save(newUser);
        return LogInSignUp.SUCCESS;
    }

    public LogInSignUp logIn(User user){
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        for (User w : users) {
            if(w.getLogged() == false){
                if(w.equals(user)) {
                    w.setLogged(true);
                    return LogInSignUp.SUCCESS;
                }
            }
        }
        return LogInSignUp.DOES_NOT_EXISTS;
    }

    public LogInSignUp logOut(User user){
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        for (User w : users) {
            if(w.getLogged() == true){
                if(w.equals(user)) {
                    w.setLogged(false);
                    return LogInSignUp.SUCCESS;
                }
            }
        }
        return LogInSignUp.FAIL;
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> getUserByUserName(String username){
        return this.userRepository.findByUsername(username);
    }

    public List<User> getUsers() {
        List<User> allUsers = new ArrayList<>();
        this.userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

}

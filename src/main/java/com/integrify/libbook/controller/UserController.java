package com.integrify.libbook.controller;

import com.integrify.libbook.bean.User;
import com.integrify.libbook.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @DeleteMapping(path = { "/{id}" })
    public boolean deleteUser(@PathVariable("id") int id) {
    if(!userRepository.findById(id).equals(Optional.empty())){
        userRepository.deleteById(id);
        return true;
    }
        return false;
    }


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
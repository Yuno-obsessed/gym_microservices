package com.sanitynil.userservice.controller;

import com.sanitynil.userservice.domain.user.User;
import com.sanitynil.userservice.domain.user.UserDao;
import com.sanitynil.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user-service")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/all")
    public ResponseEntity<List<User>> getUsers(){
       return ResponseEntity.status(200).body(userService.findAll());
    }

    @PostMapping(value = "/user/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser(@RequestBody UserDao userDao){
        if (userService.findByEmailAndPassword(userDao.getEmail(), userDao.getPassword()).isEmpty()){
            return ResponseEntity.status(401).body("No such user found");
    }
        return ResponseEntity.status(200).body("All good");
    }
}

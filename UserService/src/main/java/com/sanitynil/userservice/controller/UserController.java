package com.sanitynil.userservice.controller;

import com.sanitynil.userservice.domain.user.User;
import com.sanitynil.userservice.domain.user.UserCreateDto;
import com.sanitynil.userservice.domain.user.UserNewPassword;
import com.sanitynil.userservice.domain.user.UserOutDto;
import com.sanitynil.userservice.infra.config.exception.UserException;
import com.sanitynil.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user-service")
public class UserController {

    @Autowired
    private UserService userService;

    // Only admin
    @GetMapping(value = "/user/all")
    public ResponseEntity<List<UserOutDto>> getUsers(){
       return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/user/validate",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@RequestBody UserCreateDto userCreateDto){
        UserOutDto user = userService.findByEmailAndPassword(userCreateDto.getEmail(), userCreateDto.getPassword());
        if (user.isEmpty()){
            return ResponseEntity.status(400).body(new UserException(
                    HttpStatus.BAD_REQUEST, NullPointerException.class.toString()
            ));
    }
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/user/new",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestBody UserCreateDto userCreateDto){
        try{
            userService.saveUser(userCreateDto);
        } catch (Exception e){
            return ResponseEntity.status(400).body(new UserException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            ));
        }
        return ResponseEntity.ok("Your account was successfully created");
    }

    @PostMapping(value = "/user/update/password",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> changePassword(@RequestBody UserNewPassword userNewPassword){
        try{
            userService.changePassword(userNewPassword);
        } catch (Exception e){
            return ResponseEntity.status(400).body(new UserException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            ));
        }
        return ResponseEntity.ok("Your password was successfully changed");
    }

    @PostMapping(value = "/user/update/password")
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        /* before calling service method, send a message to auth service to check if jwt in request
         * is right and corresponds to current user
         */
        try{
            userService.updateUser(user);
        } catch (Exception e){
            return ResponseEntity.status(400).body(new UserException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            ));
        }
        return ResponseEntity.ok("Your profile data was successfully updated");
    }
}

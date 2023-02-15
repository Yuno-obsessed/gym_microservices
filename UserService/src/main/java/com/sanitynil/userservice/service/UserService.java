package com.sanitynil.userservice.service;

import com.sanitynil.userservice.domain.user.User;
import com.sanitynil.userservice.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User updateUser(User user){
        return userRepository.updateUser(user.getUsername(),
                user.getPassword(), user.getAge(), user.getCountry());
    }

    public Optional<User> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}


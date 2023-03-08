package com.sanitynil.userservice.service;

import com.sanitynil.userservice.domain.user.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public void saveUser(UserCreateDto userCreateDto) throws Exception{
        if (!userRepository.existsByEmail(userCreateDto.getEmail())){
            throw new Exception("The userDto with such email already exists");
        } else {

            String hashedPassword = passwordEncoder.encode(userCreateDto.getPassword());
            userCreateDto.setPassword(hashedPassword);

            userRepository.save(new User(userCreateDto));
        }
    }
    public void updateUser(User user) throws Exception{
        if (!userRepository.existsByPasswordAndEmail(
                user.getPassword(),user.getEmail())){
            throw new Exception("No user with such email and password exists");
        } else {
            userRepository.updateUser(user.getUsername(),
                    user.getPassword(), user.getAge(), user.getCity());
        }
    }

    public Optional<User> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    public void changePassword(UserNewPassword userNewPassword) throws Exception{
        if (!userRepository.existsByPasswordAndEmail(
                passwordEncoder.encode(userNewPassword.getOldPassword()),
                userNewPassword.getEmail())){
            throw new Exception("No user with such email and password exists");
        } else{
            userRepository.changePassword(userNewPassword.getEmail(),
                    passwordEncoder.encode(userNewPassword.getOldPassword()),
                    passwordEncoder.encode(userNewPassword.getNewPassword())
            );
        }
    }

    public List<UserOutDto> findAll(){
        // exclude admin
        return userRepository.findAll();
    }
}


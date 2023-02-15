package com.sanitynil.authservice.infra.security;

import com.sanitynil.authservice.domain.login.LoginDao;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;


@Configuration
@AllArgsConstructor
public class CustomUserDetails {

    private final LoginDao loginDao;

//    private final static List<UserDetails> appUsers = Arrays.asList(
//            new User(
//                    "example@gmail.com",
//                    "wordpass",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
//            ),
//            new User(
//                    "usermail@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//            )
//    );

    @Bean
    public UserDetailsService userDetailsService(){
        return email -> {
            System.out.println(loginDao.getEmail() + loginDao.getPassword());
            if (this.loginDao.getEmail().equals(email)) {
                return new User(this.loginDao.getEmail(),
                        this.loginDao.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
            } else {
                throw new UsernameNotFoundException("No such user found");
            }
        };

//        return email -> appUsers
//                .stream()
//                .filter(u -> u.getUsername().equals(email))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException("No such user found"));
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

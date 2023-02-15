package com.sanitynil.authservice.controller;

import com.sanitynil.authservice.domain.login.Login;
import com.sanitynil.authservice.domain.login.LoginDao;
import com.sanitynil.authservice.infra.security.CustomUserDetails;
import com.sanitynil.authservice.infra.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value = "/api/v1/auth-service")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final RestTemplate restTemplate;

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping(value = "/auth")
    public ResponseEntity<String> authenticate(@RequestBody LoginDao loginDao){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDao.getEmail(),loginDao.getPassword())
        );
        System.out.println(loginDao.getEmail() + loginDao.getPassword());
        String url = "http://localhost:8082/api/v1/user-service/user/validate";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<LoginDao> payload = new HttpEntity<>(loginDao, headers);

        // if I am doing a request like this, is it blocked by authentication or not?
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(loginDao), String.class);
        System.out.println(response.getBody());
        final CustomUserDetails user = new CustomUserDetails(loginDao);
        if (response.getStatusCode() == HttpStatus.OK){
           // call mail-service
            return ResponseEntity.ok(jwtUtils.generateToken(user.userDetailsService().loadUserByUsername(loginDao.getEmail())));
        }
        return ResponseEntity.status(401).body("Such user wasn't found");
    }

}

package com.sanitynil.userservice.infra.config;

import com.sanitynil.userservice.domain.user.UserRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.sanitynil.userservice.domain.user", repositoryBaseClass = UserRepository.class)
public class App {
}

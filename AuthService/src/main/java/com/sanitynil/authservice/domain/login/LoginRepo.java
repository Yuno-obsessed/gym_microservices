package com.sanitynil.authservice.domain.login;

public interface LoginRepo {
    boolean ExistsWithCredentials(String email, String password);
    long GetId(String email, String password);
}

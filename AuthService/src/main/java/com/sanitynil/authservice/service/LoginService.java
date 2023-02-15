package com.sanitynil.authservice.service;

import com.sanitynil.authservice.domain.login.LoginRepo;

public class LoginService implements LoginRepo {
    @Override
    public boolean ExistsWithCredentials(String email, String password) {
        return false;
    }

    @Override
    public long GetId(String email, String password) {
        return 0;
    }
}

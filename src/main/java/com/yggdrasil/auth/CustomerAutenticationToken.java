package com.yggdrasil.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class CustomerAutenticationToken extends AbstractAuthenticationToken {
    private String userName;
    private String userPassword;

    public CustomerAutenticationToken(String userName) {
        super(null);
        this.userName = userName;
        setAuthenticated(true);
    }

    public CustomerAutenticationToken(String userName, String userPassword) {
        super(null);
        this.userName = userName;
        this.userPassword = userPassword;

    }

    @Override
    public Object getCredentials() {

        return this.userPassword;
    }

    @Override
    public Object getPrincipal() {
        return this.userName;
    }
}

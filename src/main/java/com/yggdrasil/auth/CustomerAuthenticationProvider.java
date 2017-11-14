package com.yggdrasil.auth;

import com.yggdrasil.exception.InternalException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        this.assertAutenticationToken(authentication);
        final String userName = authentication.getPrincipal().toString();
        final String userPassword = authentication.getPrincipal().toString();
        this.assertUserNameWithPassword(userName, userPassword);

        return new CustomerAutenticationToken(userName);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public void assertAutenticationToken(Authentication authentication) {
        if (null == authentication.getCredentials() || null == authentication.getPrincipal()) {
            throw new InternalException();
        }
    }

    public void assertUserNameWithPassword(String userName, String userPassword) {
        /*校验密码操作*/
    }
}

package com.yggdrasil.auth;

import com.yggdrasil.api.user.UserService;
import com.yggdrasil.exception.CustomerInternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        this.assertAutenticationToken(authentication);
        final String userName = authentication.getPrincipal().toString();
        final String userPassword = authentication.getCredentials().toString();
        this.assertUserNameWithPassword(userName, userPassword);

        return new CustomerAutenticationToken(userName);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public void assertAutenticationToken(Authentication authentication) {
        if (null == authentication.getCredentials() || null == authentication.getPrincipal()) {
            throw new CustomerInternalException();
        }
    }

    public void assertUserNameWithPassword(String userName, String userPassword) {
        /*校验密码操作*/
        // throw new RuntimeException();
        userService.assertUserByNamePassword(userName, userPassword);

    }
}

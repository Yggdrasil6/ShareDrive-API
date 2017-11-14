package com.yggdrasil.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yggdrasil.exception.CustomerAuthenticationException;
import com.yggdrasil.user.domain.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
    private HttpStatusEntryPoint authenticationEntryPoint = new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
    public static final String LOGIN_PATH = "/login";
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!request.getRequestURL().equals(LOGIN_PATH)) {
            filterChain.doFilter(request, response);
            return;
        }
        final Authentication authenticationResult;
        try {
            LoginInfo userInfo = new ObjectMapper().readValue(request.getInputStream(), LoginInfo.class);
            authenticationResult = authenticationManager.authenticate(new CustomerAutenticationToken(userInfo.getUserName(), userInfo.getUserPassword()));
        } catch (Exception e) {
            logger.error(e.getMessage());
            SecurityContextHolder.clearContext();
            authenticationEntryPoint.commence(request, response, new CustomerAuthenticationException(e.getMessage(), e));
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationResult);
        filterChain.doFilter(request, response);

    }
}

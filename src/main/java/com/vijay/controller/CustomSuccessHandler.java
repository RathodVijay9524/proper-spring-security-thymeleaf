package com.vijay.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub

        var authourities = authentication.getAuthorities();
        var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();

        if (roles.orElse("").equals("ROLE_ADMIN")) {
            response.sendRedirect("/admin");
        } else if (roles.orElse("").equals("ROLE_USER")) {
            response.sendRedirect("/user");
        } else if (roles.orElse("").equals("ROLE_NORMAL")) {
            response.sendRedirect("/normal");
           }else {
            response.sendRedirect("/error");
        }



    }

}
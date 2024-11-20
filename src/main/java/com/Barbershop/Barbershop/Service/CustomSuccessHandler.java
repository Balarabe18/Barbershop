package com.Barbershop.Barbershop.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String redirectUrl = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ADMIN")) ? "/admin-page" : "/user-page";

        response.sendRedirect(redirectUrl);
    }
}
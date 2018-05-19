package com.codecool.crudinventorymanagementapp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException {

    }

    private String setTargetUrl(Authentication authentication, HttpServletRequest request) {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_EMPLOYEE")) {
            return request.getContextPath() + "/inventory";
        } else if (roles.contains("ROLE_ADMIN")) {
            return "/employee";
        } else {
            return "/login";
        }
    }
}
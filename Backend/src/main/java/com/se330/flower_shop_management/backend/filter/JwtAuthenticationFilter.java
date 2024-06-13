package com.se330.flower_shop_management.backend.filter;

import com.se330.flower_shop_management.backend.entity.User;
import com.se330.flower_shop_management.backend.service.JwtService;
import com.se330.flower_shop_management.backend.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    @Lazy
    private UserService userService;

    private static final List<String> EXCLUDED_PATHS = Arrays.asList("/login", "/signup", "/email-exists", "/send-email", "/change-password");

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            String path = request.getRequestURI();
            if (EXCLUDED_PATHS.stream().anyMatch(path::startsWith)) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = getJwtFromRequest(request);

            if (token == null || token.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"msg\": \"No auth token, access denied.\"}");
                return;
            }

            Long userId;
            try {
                userId = jwtService.extractUserId(token); // assuming this method throws an exception if invalid
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"msg\": \"Token verification failed, authorization denied.\"}");
                return;
            }

            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userService.loadUserById(userId);
                String userRole = jwtService.extractUserRole(token);

                if (user != null && userRole != null) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
                    user.setAuthorities(Collections.singletonList(authority));

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    request.setAttribute("user", user);
                    request.setAttribute("token", token);
                }
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
            return;
        }

        filterChain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null); // Clear context after request is processed
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        return request.getHeader("x-auth-token");
    }
}
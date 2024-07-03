package com.example.booking88be.config.Filter;

import com.example.booking88be.entity.Customer;
import com.example.booking88be.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;


import java.io.IOException;
import java.util.List;

@Component
public class Filter extends OncePerRequestFilter {

    private final List<String> AUTH_PERMISSION = List.of(
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/login/**",
            "/register",
            "/send-mail",
            "/login-google",
            "/account/**",
            "/create",
            "/getAll",
            "/account/remove/**",
            "/update",
            "/locat/**",
            "/setStatus/**",
            "/admin/**",
            "/owner/**",
            "/Staff/**",
            "/Customer/**"

    );
    @Autowired
    TokenService tokenService;
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    private boolean isPermitted(String uri) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        return AUTH_PERMISSION.stream().anyMatch(pattern -> pathMatcher.match(pattern, uri));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (isPermitted(uri)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getToken(request);
        if (token == null) {
            resolver.resolveException(request, response, null, new AuthException("Empty token!"));
            return;
        }

        try {
            Customer customer = tokenService.extractAccount(token);
            UsernamePasswordAuthenticationToken authenToken =
                    new UsernamePasswordAuthenticationToken(customer, token, customer.getAuthorities());
            authenToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenToken);
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException expiredJwtException) {
            resolver.resolveException(request, response, null, new AuthException("Expired Token!"));
        } catch (MalformedJwtException malformedJwtException) {
            resolver.resolveException(request, response, null, new AuthException("Invalid Token!"));
        } catch (Exception e) {
            resolver.resolveException(request, response, null, new AuthException("Authentication error: " + e.getMessage()));
        }
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;
        return authHeader.substring(7);
    }
}
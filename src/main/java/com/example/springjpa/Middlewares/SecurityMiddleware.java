package com.example.springjpa.Middlewares;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class SecurityMiddleware implements Filter {

    Logger logger = LoggerFactory.getLogger(SecurityMiddleware.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("request:middleware:passed security");
        chain.doFilter(
                request,
                response
        );
    }
}

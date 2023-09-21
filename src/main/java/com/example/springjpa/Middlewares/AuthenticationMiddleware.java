package com.example.springjpa.Middlewares;


import com.example.springjpa.objects.MutableHttpServletRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(2)
public class AuthenticationMiddleware implements Filter {

    Logger log = LoggerFactory.getLogger(AuthenticationMiddleware.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest((HttpServletRequest) request) ;
        mutableRequest.setHeader("user","admin");
        log.info("middleware:passed authentication");



        chain.doFilter(
                mutableRequest,
                response
        );
    }
}
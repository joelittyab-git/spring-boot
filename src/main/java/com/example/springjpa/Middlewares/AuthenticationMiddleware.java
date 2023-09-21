package com.example.springjpa.Middlewares;


import com.example.springjpa.objects.MutableHttpServletRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;



@Component
public class AuthenticationMiddleware implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest((HttpServletRequest) request) ;
        mutableRequest.setHeader("user","admin");



        chain.doFilter(
                mutableRequest,
                response
        );
    }
}
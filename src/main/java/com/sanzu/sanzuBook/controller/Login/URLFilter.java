package com.sanzu.sanzuBook.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/*")
public class URLFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(isVueRouter(req.getServletPath())) {
            req.getRequestDispatcher("/index.html").forward(req,resp);
        }
        else chain.doFilter(req,resp);
    }
    private boolean isVueRouter(String path){
        return ("/home".equals(path)||
                "/login".equals(path)||
                "/recommend".equals(path)||
                "/books".equals(path)||
                "/discuss".equals(path)||
                "/join".equals(path)||
                "/search".equals(path)||
                "/details".startsWith(path)||
                "/email".equals(path)
        );
    }
}


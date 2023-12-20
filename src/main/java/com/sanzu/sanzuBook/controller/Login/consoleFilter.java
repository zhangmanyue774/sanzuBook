package com.sanzu.sanzuBook.controller.Login;

import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.controller.bookReview.WebSocketServerTest;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.InetSocketAddress;

@WebFilter("/console/*")
public class consoleFilter implements Filter {
    public static WebSocketServerTest webSocketServerTest;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取拦截的token
        Cookie[] cookies = req.getCookies();
        String token = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("admin_token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println(token);
        //判断用户token是否过期
        if (token != null) {
            // 判断用户token是否过期，调用一个验证方法
            boolean isTokenValid = JwtUtil.verifyToken(token);
            if (isTokenValid) {
                // Token有效，执行后续逻辑
                if(req.getServletPath().equals("/console")) {
                    webSocketServerTest =  new WebSocketServerTest(new InetSocketAddress("0.0.0.0",1315));
                    webSocketServerTest.start();
                    req.getRequestDispatcher("/index.html").forward(req, resp);
                }
                else chain.doFilter(req,resp);
            }
            else {
                resp.setContentType("application/json;charset=UTF-8");
                resp.getWriter().write("用户登录失效，请重新登录！");
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        else {
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write("用户没有访问权限");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

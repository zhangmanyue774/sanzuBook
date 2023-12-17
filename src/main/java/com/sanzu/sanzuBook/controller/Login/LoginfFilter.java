package com.sanzu.sanzuBook.controller.Login;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/api/login/*")
public class LoginfFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        boolean isLogin = false;
        if(req.getServletPath().equals("/api/login")) {
            isLogin = true;
            chain.doFilter(req,resp);
        }
        //获取拦截的token
        String token = req.getHeader("Authorization");
        //判断用户token是否过期
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // 去除 "Bearer " 前缀

            // 判断用户token是否过期，例如调用一个验证方法
            boolean isTokenValid = JwtUtil.verifyToken(token);
            if (isTokenValid) {
                // Token有效，执行后续逻辑
                chain.doFilter(req,resp);
            }
            else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }

//        if (isWhite(req.getServletPath())) {
//            chain.doFilter(req, res);
//        }
            //判断用户session是否存在
//        if (null != session.getAttribute("username")) {
//            chain.doFilter(req, res);
//        } else {
//            Cookie[] cookies = req.getCookies();
//            for (Cookie cookie : cookies) {
//                if ("username".equals(cookie.getName())) {
//                    session.setAttribute("username", cookie.getValue());
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag) chain.doFilter(req,res);
//            }
//            chain.doFilter(req,res);
//        }

}
//        //判断当前路径是否属于白名单
//        private boolean isWhite (String path){
//            return (
//                    "/index.html".equals(path) ||
//                            path.startsWith("/assets/") ||
//                            "/favicon.ico".equals(path) ||
//                            "/logo.png".equals(path) ||
//                            "/login".equals(path)
//            );
//
//    }
//}

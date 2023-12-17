package com.sanzu.sanzuBook.controller.CollectBook;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.entity.CollectEntity;
import com.sanzu.sanzuBook.service.CollectService;
import com.sanzu.sanzuBook.service.impl.CollectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/login/getUserCollect")
public class getUserCollect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("Authorization");
        //判断用户token是否过期
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // 去除 "Bearer " 前缀
        }
        Integer userID = JwtUtil.getUserIDFromToken(token);
        CollectService collectService = new CollectServiceImpl();
        List<CollectEntity> userCollect = collectService.getSelectCollects(userID);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(userCollect));
    }
}

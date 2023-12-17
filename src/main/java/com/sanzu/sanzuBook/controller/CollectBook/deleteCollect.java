package com.sanzu.sanzuBook.controller.CollectBook;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.service.BookService;
import com.sanzu.sanzuBook.service.CollectService;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import com.sanzu.sanzuBook.service.impl.CollectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/api/login/deleteCollect")
public class deleteCollect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookId = Integer.valueOf(req.getParameter("bookID"));
        String token = req.getHeader("Authorization");
        //判断用户token是否过期
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // 去除 "Bearer " 前缀
        }
        Integer userID = JwtUtil.getUserIDFromToken(token);
        CollectService collectService = new CollectServiceImpl();
        Integer result = collectService.getDeleteCollect(bookId,userID);
        resp.setContentType("application/json;charset=UTF-8");
        if(result ==1) {
            BookService bookService = new BookServiceImpl();
            bookService.getReduceLikes(bookId);
            resp.getWriter().write(JSON.toJSONString("删除成功"));
        }
        else resp.getWriter().write("删除错误");
    }
}

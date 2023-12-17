package com.sanzu.sanzuBook.controller.Search;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.entity.BookEntity;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/TypeBook")
public class searchTypeBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        String type = req.getParameter("type");
        BookServiceImpl bookServicelmpl = new BookServiceImpl();
        List<BookEntity> bookType= bookServicelmpl.getSelectTypeBook(type);
        resp.getWriter().write(JSON.toJSONString(bookType));
    }
}

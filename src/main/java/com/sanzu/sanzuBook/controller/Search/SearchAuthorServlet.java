package com.sanzu.sanzuBook.controller.Search;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.entity.BookEntity;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/SearchAuthor")
public class SearchAuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 允许所有来源进行跨域访问
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json;charset=UTF-8");
        String Author= req.getParameter("keyword");
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        List<BookEntity> searchResult = bookServiceImpl.getSelectAuthor(Author);
        List<BookEntity> newResult = new ArrayList<>();
        for (BookEntity book:searchResult) {
            String originalAuthor = book.getAuthor();
            String highlightedAuthor = StringUtils.replaceIgnoreCase(originalAuthor, Author,
                    "<span style=\"color: #7B1FA2;\">" + Author + "</span>");
            book.setAuthor(highlightedAuthor);
            newResult.add(book);
        }
        String json = JSON.toJSONString(newResult);
        resp.getWriter().write(json);
    }
}

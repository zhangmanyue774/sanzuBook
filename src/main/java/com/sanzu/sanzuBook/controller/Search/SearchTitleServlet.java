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

@WebServlet("/api/searchTitle")
public class SearchTitleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 允许所有来源进行跨域访问
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json;charset=UTF-8");
        String title = req.getParameter("keyword");
        String isTrue = req.getParameter("isTrue");

        // 查询服务调用
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        List<BookEntity> searchResult = bookServiceImpl.getSelectTitle(title);

        if (isTrue != null && isTrue.equalsIgnoreCase("true")) {
            // 返回原始查询数据
            String json = JSON.toJSONString(searchResult);
            resp.getWriter().write(json);
        } else {
            // 关键词突出
            List<BookEntity> newResult = new ArrayList<>();
            for (BookEntity book : searchResult) {
                String originalTitle = book.getTitle();
                String highlightedTitle = StringUtils.replaceIgnoreCase(originalTitle, title,
                        "<span style=\"color: #7B1FA2;\">" + title + "</span>");
                book.setTitle(highlightedTitle);
                newResult.add(book);
            }
            String json = JSON.toJSONString(newResult);
            resp.getWriter().write(json);
        }
    }
}
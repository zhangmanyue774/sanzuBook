package com.sanzu.sanzuBook.controller.bookReview;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.entity.ReviewEntity;
import com.sanzu.sanzuBook.service.ReviewService;
import com.sanzu.sanzuBook.service.impl.ReviewServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * 书评分页查询
 */
@WebServlet("/api/reviewShow")
public class reviewShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));//页码
        System.out.println(pageNum);
        int pageSize = 5; // 每页的记录数
        int startRow = (pageNum - 1) * pageSize;
        ReviewService reviewService = new ReviewServiceImpl();
        List<ReviewEntity> reviews = reviewService.getShowReviewEntity(startRow,pageSize);
        String json = JSON.toJSONString(reviews);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(json);
    }
}

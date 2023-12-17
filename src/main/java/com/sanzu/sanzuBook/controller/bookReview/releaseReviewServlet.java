package com.sanzu.sanzuBook.controller.bookReview;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.entity.BookEntity;
import com.sanzu.sanzuBook.service.BookService;
import com.sanzu.sanzuBook.service.ReviewService;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import com.sanzu.sanzuBook.service.impl.ReviewServiceImpl;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import com.sanzu.sanzuBook.vo.UserCVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户发布书评
 */

@WebServlet("/api/login/releaseReview")
public class releaseReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("近来了");
        String token = req.getHeader("Authorization");
        //判断用户token是否过期
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // 去除 "Bearer " 前缀
        }
       //用户名
        String username = JwtUtil.getUsernameFromToken(token);
        UserService userService = new UserServicelmpl();
        UserCVo userCVo = userService.getUserMessage(username);
        String avatar = userCVo.getAvatar();
        //书评
        String review = req.getParameter("review");
       //书本id
        String id = req.getParameter("id");
        BookService bookService = new BookServiceImpl();
        BookEntity book = bookService.getSelectID(Integer.valueOf(id));
        String title = book.getTitle();
        String cover = book.getCover();
        String author = book.getAuthor();
        System.out.println("增加书评");
        Map<String, Object> map = new HashMap<>();
        String json = "";
            map.put("username", username);
            map.put("review", review);
            map.put("title", title);
            map.put("cover", cover);
            map.put("avatar",avatar);
            map.put("author",author);
            map.put("bookID",Integer.valueOf(id));
            map.put("email",JwtUtil.getAccountFromToken(token));
            ReviewService reviewService = new ReviewServiceImpl();
            reviewService.getInsertReview(map);
            json=JSON.toJSONString("发布成功！");
        userService.getUpdateOperation(userService.getSelectAccount(JwtUtil.getAccountFromToken(token)).getId(),
                "发布书评:"+
                        (java.time.LocalDateTime.now().
                                format(java.time.format.DateTimeFormatter.
                                        ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+
                                "操作IP:"+ request.getIPv4(req)));
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(json);
    }
}

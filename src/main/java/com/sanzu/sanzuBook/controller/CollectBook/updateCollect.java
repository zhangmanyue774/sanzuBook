package com.sanzu.sanzuBook.controller.CollectBook;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.common.JwtUtil;
import com.sanzu.sanzuBook.common.request;
import com.sanzu.sanzuBook.entity.BookEntity;
import com.sanzu.sanzuBook.service.BookService;
import com.sanzu.sanzuBook.service.CollectService;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import com.sanzu.sanzuBook.service.impl.CollectServiceImpl;
import com.sanzu.sanzuBook.service.impl.UserServicelmpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/login/updateCollect")
public class updateCollect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("Authorization");
        //判断用户token是否过期
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // 去除 "Bearer " 前缀
            System.out.println(token);
        }
        Integer userID = JwtUtil.getUserIDFromToken(token);
        System.out.println(userID);
        String bookID = req.getParameter("bookID");
        System.out.println(bookID);
        BookService bookService =new BookServiceImpl();
        BookEntity bookEntity = bookService.getSelectID(Integer.valueOf(bookID));
        Map<String,Object> map = new HashMap<>();
        map.put("userID",userID);
        map.put("cover",bookEntity.getCover());
        map.put("title",bookEntity.getTitle());
        map.put("author",bookEntity.getAuthor());
        map.put("bookID",Integer.valueOf(bookID));
        CollectService collectService=new CollectServiceImpl();
        Integer result = collectService.getInsertCollect(map);
        resp.setContentType("application/json;charset=UTF-8");
        if(result ==1) {
            bookService.getUpdateLikes(Integer.valueOf(bookID));
            UserService userService = new UserServicelmpl();
            userService.getUpdateOperation(userService.getSelectAccount(JwtUtil.getAccountFromToken(token)).getId(),
                    "收藏书籍:"+
                            (java.time.LocalDateTime.now().
                                    format(java.time.format.DateTimeFormatter.
                                            ofPattern("yyyy-MM-dd HH:mm:ss"))+"\n"+
                                    "操作IP:"+ request.getIPv4(req)));
            resp.getWriter().write(JSON.toJSONString("添加成功"));
        }
        else resp.getWriter().write(JSON.toJSONString("添加失败"));
    }
}

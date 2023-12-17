package com.sanzu.sanzuBook.controller.Search;

import com.alibaba.fastjson.JSON;
import com.sanzu.sanzuBook.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/searchFocus")
public class searchFocusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        String keyword = req.getParameter("keyword");
        resp.setContentType("application/json;charset=UTF-8");
        String json ="";
        if(keyword.isEmpty()){
            Map<String,Object> map = new HashMap<>();
            map.put("message","输入作者或作品名进行查询");
            json = JSON.toJSONString(map);
        }
        else {
            List<String> searchResult = bookServiceImpl.selectSearch(keyword);
            if(searchResult.isEmpty()){
                resp.setContentType("application/json;charset=UTF-8");
                Map<String,Object> map = new HashMap<>();
                map.put("message","未查询到相关书籍");
                json = JSON.toJSONString(map);
            }
            else {
            //优化
            List<String> newResult = new ArrayList<>();
            for (String value : searchResult) {
                String highlightedValue = StringUtils.replaceIgnoreCase(value, keyword,
                        "<span style=\"color: #7B1FA2;\">" + keyword + "</span>");
                newResult.add(highlightedValue);
            }
            resp.setContentType("application/json;charset=UTF-8");
            Map<String,Object> map = new HashMap<>();
            map.put("searchClick",searchResult);
            map.put("searchFocus:",newResult);
            json = JSON.toJSONString(map);}
        }
        resp.getWriter().write(json);
    }
}

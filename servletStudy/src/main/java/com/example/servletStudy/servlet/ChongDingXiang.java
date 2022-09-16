package com.example.servletStudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向：
 * 1. 重定向是客户端行为
 * 2. 重定向是浏览器至少做了两次请求
 * 3. 重定向浏览器地址改变
 * 4. 重定向可以指向任何资源，比如百度
 * */
@WebServlet("/chushidizhi")
public class ChongDingXiang extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //把servletStudy_war_exploded/chongxingxiangdizhi?name=zhangsan 返回给客户端，客户端在进行请求，可以传参数，但是只能传String
        // 需要加上 servletStudy_war_exploded
        //resp.sendRedirect("/servletStudy_war_exploded/chongxingxiangdizhi?name=zhangsan");
        resp.sendRedirect("https://www.baidu.com");
    }
}

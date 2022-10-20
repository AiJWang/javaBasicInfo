package com.example.servletStudy.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session: 存储在服务器，用于记录用户的状态，指的是单个客户端与服务器一连串相关的交互过程
 * 1. 服务器为每一次会话分配一个session对象
 * 2. 同一个浏览器的多次请求，属于一个session
 * 3. 首次使用session时，服务器自动创建session，并创建cookie存储sessionId返回给客户端
 *
 * session作用域：拥有存储数据的空间，作用范围是一次会话
 * 一次会话：统一浏览器发起的多次请求，浏览器关闭，则会话结束
 * 可将数据存入session中，在一次会话的任意位置获取(从其他的请求里也可以获取，请看getSession 类)
 * 可传递任何数据（基本数据类型，对象，集合，数组）
 * */
@WebServlet(value = "/getSession")
public class SessionStudy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取session对象
        HttpSession session=req.getSession();
        //设置session对象
        session.setAttribute("usr","waj");
        //删除session的键值对
        session.removeAttribute("aa");
        //设置session有效期 30s，session失效后，会自动创建一个新的；直接销毁session： session.invalidate();
        session.setMaxInactiveInterval(30);
        session.invalidate();
        System.out.println(session.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}


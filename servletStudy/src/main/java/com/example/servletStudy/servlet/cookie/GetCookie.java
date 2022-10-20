package com.example.servletStudy.servlet.cookie;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(value = "/getCookie")
public class GetCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        if (null != cookies){
            for (Cookie cookie:cookies){
                System.out.println(URLDecoder.decode(cookie.getName(),"utf-8")+":"+URLDecoder.decode(cookie.getValue(),"utf-8"));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

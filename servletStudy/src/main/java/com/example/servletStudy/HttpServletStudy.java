package com.example.servletStudy;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 这个servlet是针对http请求的，之前的不是只只对http请求的
* */
public class HttpServletStudy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("这是个get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("这是post请求");
    }
}

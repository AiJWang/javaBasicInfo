package com.example.servletStudy.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
/*
* GenericServlet: 一个抽象类
* 只需要重写service方法就行，跟实现Servlet一样
* 与协议无关，可以不是http
* */
public class GenServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenServlet");
    }
}

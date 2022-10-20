package com.example.servletStudy.servlet.servletContext;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 1. 全局对象，拥有作用域，对应一个tomcat的web应用
 * 2. 当web服务启动时创建，服务器关闭时销毁
 * 3. 获取S而vletContext有三种方式，见下面代码，三种方式获取的都是同一个，因为一个web应用只有1个servletContext
 * serveletContext特点：
 *   1. 唯一性，一个应用只对应一个servletContext
 *   2. 生命周期，只要容器不关闭或者应用不卸载，servletContext就一直在
 * 使用场景：
 *  1. 统计项目被访问多少次
 * */
@WebServlet(name = "ServletContextBasicInfo",value="/servletContextController")
public class ServletContextBasicInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext方式1  推荐
        ServletContext servletContext = this.getServletContext();
        //获取servletContext方式2    推荐
        ServletContext servletContext1= req.getServletContext();
        //方式3
        HttpSession session=req.getSession();
        ServletContext servletContext2= session.getServletContext();
        //用途1 获取当前项目真实路径  D:\javaBasicInfo\javaBasicInfo\servletStudy\target\servletStudy-1.0-SNAPSHOT\
        System.out.println("current path-->"+servletContext.getRealPath("/"));
        //用途2 获取项目名称，就是tomcat里配置的那个
        System.out.println("pro name-->"+servletContext.getContextPath());
        //用途3  存储全局数据，整个web应用都可以用的，这种数据比较少
        servletContext.setAttribute("code",1);
        int a=(int)servletContext.getAttribute("code");
        System.out.println("a-->"+a);
    }
}

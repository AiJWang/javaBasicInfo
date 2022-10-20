package com.example.servletStudy.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Date;

/*
* servlet学习：
* 实现servlet，重写方法
* 部署项目步骤 手动：
* 1. 在Tomcat  webapps文件夹内新建个文件夹 myservlet
* 2. 在myservlet文件夹内建个WEB-INF 文件夹，里面有个web.xml文件，有lib文件夹，有classes文件夹
* 3. classes文件里放的是编译后的myservlet文件，是全路径的文件，包括com，example，需要跟web.xml中 servlet-class路径一致
* 4. 启动Tomcat，访问 localhost:8080/myservlet/myservlet 就访问到自己写的servlet了
* idea可自动部署Tomcat：
* 1. settings-->Application servers--》添加Tomcat
* 2. 右上角Edit configuration 添加Tomcat，点击ok
* 3. 然后直接点有商家偶的执行，启动tomcat就行了
* 4. idea 中是热部署，不会吧代码放到Tomcat的webapps中，而是放到自己的target中
* 5. 如果需要发布上线，需要达成war包才行，放到webapps下
* 打war包顺序：
* 1. Project Structure -->Artifacts-->点击+号-->Web Application Arctive-->for xxx exploded (这是选择war包)
* 2. 打包  build-->Build Artifacts-->选择war包点击build（注意，不是exploded）-->此时war包被放到了target下
* 3. 将war包复制到Tomcat webapps下，Tomcat启动的时候会自动解压的,然后启动tomcat，访问就行了
* */
@WebServlet(value = "/myServlet")
public class myServlet implements Servlet {

    public myServlet(){
        System.out.println("1. 构建");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. 初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //这个是主要方法，写逻辑的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("this is my first servlet");
        System.out.println(new Date());

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("3. 销毁");
    }
}

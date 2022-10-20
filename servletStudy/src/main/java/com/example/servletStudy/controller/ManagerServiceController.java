package com.example.servletStudy.controller;

import com.example.servletStudy.entity.Manager;
import com.example.servletStudy.service.ManagerService;
import com.example.servletStudy.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginManager")
public class ManagerServiceController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2. 获取参数
        String username=req.getParameter("username");
        String PWD=req.getParameter("password");
        //获取用户传过来的验证码
        String verifyCode=req.getParameter("verifyCode");
        //获取验证码生成时存在session中的验证码
        String code=(String) req.getSession().getAttribute("validateCode");
        if (!verifyCode.isEmpty()&&verifyCode.equalsIgnoreCase(code)){
            //3. 调用业务方法
            ManagerService managerService=new ManagerServiceImpl();
            Manager m=managerService.login(username,PWD);
            //4. 处理结果，流程跳转，跳转到注册页面还是登陆成功页面啊
            if (null!= m){
                //登陆成功，将用户信息存进session里，然后跳转页面,跳转到查询所有信息页面
                HttpSession session=req.getSession();
                session.setAttribute("manager",m);
                resp.sendRedirect("/servletStudy_war_exploded/showAllController");
            }else {
                resp.sendRedirect("/servletStudy_war_exploded/loginMgr.html");
            }
        }else {
            resp.sendRedirect("/servletStudy_war_exploded/loginMgr.html");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

package com.example.ServletFinalPractise.controller;

import com.example.ServletFinalPractise.entity.EmpManager;
import com.example.ServletFinalPractise.service.EmpManagerService;
import com.example.ServletFinalPractise.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/manager/login")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        String verifyCode=req.getParameter("verifyCode");
        HttpSession session=req.getSession();
        String codes=(String)session.getAttribute("verifyCode");
        if (codes.equalsIgnoreCase(verifyCode)){
            EmpManagerService empManagerService=new EmpManagerServiceImpl();
            EmpManager login = empManagerService.login(username, pwd);
            if (null!=login){
                //存储在session作用域
                HttpSession session1=req.getSession();
                session1.setAttribute("empManager",login);
                //跳转到查询所有的controller
                resp.sendRedirect(req.getContextPath()+"/manager/safe/showAllEmp");
            }else {
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

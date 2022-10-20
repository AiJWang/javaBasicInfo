package com.example.servletStudy.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//自动生成验证码 ValidateCode,这是个单独导的jar包，需要通过 project structure->library  添加一下，然后还得加到tomcat的lib文件夹里
@WebServlet(name = "verifyCode",value = "/getVerifyCode")
public class VerifyCodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建验证码图片
        ValidateCode validateCode=new ValidateCode(200,30,4,20);
        HttpSession session= req.getSession();
        session.setAttribute("validateCode",validateCode.getCode());
        //生成验证码图片，响应给客户端
        validateCode.write(resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

package com.example.servletStudy.servlet;

import com.example.servletStudy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showjsp")
public class ShowJsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=(List<User>) req.getAttribute("userList");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        for (User user:userList){
            printWriter.println(user.getUserName());
            printWriter.println(user.getAddress());
            printWriter.println(user.getIphone());
            printWriter.println(user.getPASSWORD());
            printWriter.println("br");
        }
    }
}

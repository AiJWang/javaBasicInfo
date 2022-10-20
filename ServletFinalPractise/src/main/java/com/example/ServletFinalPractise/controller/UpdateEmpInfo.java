package com.example.ServletFinalPractise.controller;

import com.example.ServletFinalPractise.Utils.SqlSessionUtil;
import com.example.ServletFinalPractise.entity.Emp;
import com.example.ServletFinalPractise.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/manager/safe/updateEmpInfo")
public class UpdateEmpInfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        double salary= Double.parseDouble(req.getParameter("salary"));
        int age=Integer.parseInt(req.getParameter("age"));
        Emp emp=new Emp(id,name,salary,age);
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            EmpMapper empMapper=session.getMapper(EmpMapper.class);
            empMapper.update(emp);
            resp.sendRedirect(req.getContextPath()+"/manager/safe/showAllEmp");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

package com.example.ServletFinalPractise.controller;

import com.example.ServletFinalPractise.Utils.SqlSessionUtil;
import com.example.ServletFinalPractise.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/manager/safe/removeEmp")
public class RemoveEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            EmpMapper empMapper=session.getMapper(EmpMapper.class);
            empMapper.deleteEmpById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        resp.sendRedirect(req.getContextPath()+"/manager/safe/showAllEmp");
    }
}

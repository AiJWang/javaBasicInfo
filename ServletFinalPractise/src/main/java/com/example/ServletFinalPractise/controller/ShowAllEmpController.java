package com.example.ServletFinalPractise.controller;

import com.example.ServletFinalPractise.Utils.SqlSessionUtil;
import com.example.ServletFinalPractise.entity.Emp;
import com.example.ServletFinalPractise.entity.EmpManager;
import com.example.ServletFinalPractise.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/safe/showAllEmp")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try(SqlSession session= SqlSessionUtil.getSqlSession()){
           EmpMapper empMapper=session.getMapper(EmpMapper.class);
           List<Emp> empList=empMapper.getAllEmp();
           req.setAttribute("empList",empList);
           req.getRequestDispatcher("/manager/safe/showAllEmpJSP").forward(req,resp);
       }catch (Exception e){
           System.out.println(e);
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

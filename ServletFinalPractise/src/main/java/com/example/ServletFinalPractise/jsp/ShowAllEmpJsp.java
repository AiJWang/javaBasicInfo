package com.example.ServletFinalPractise.jsp;

import com.example.ServletFinalPractise.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/manager/safe/showAllEmpJSP")
public class ShowAllEmpJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> empList=(List<Emp>)req.getAttribute("empList");
        PrintWriter printWriter= resp.getWriter();
        printWriter.println("<html>");
        printWriter.println(" <head>");
        printWriter.println("   <meta charset=utf-8>");
        printWriter.println("   <title>显示所有员工</title>");
        printWriter.println(" </head>");
        printWriter.println(" <body>");
        printWriter.println("   <table border='1'>");
        printWriter.println("   <tr>");
        printWriter.println("       <td>编号</td>");
        printWriter.println("       <td>姓名</td>");
        printWriter.println("       <td>工资</td>");
        printWriter.println("       <td>年龄</td>");
        printWriter.println("       <td colspan='2'>操作</td>");
        printWriter.println("   <tr>");
        for (Emp emp:empList){
            printWriter.println("   <tr>");
            printWriter.println("       <td>"+emp.getId()+"</a></td>");
            printWriter.println("       <td>"+emp.getName()+"</td>");
            printWriter.println("       <td>"+emp.getSalary()+"</td>");
            printWriter.println("       <td>"+emp.getAge()+"</td>");
            printWriter.println("       <td><a href='"+req.getContextPath()+"/manager/safe/removeEmp?id="+emp.getId()+"'>"+"删除"+"</a></td>");
            printWriter.println("       <td><a href='"+req.getContextPath()+"/manager/safe/getEmpById?id="+emp.getId()+"'>"+"修改"+"</a></td>");
            printWriter.println("   <tr>");
        }
        printWriter.println("   </table>");
        printWriter.println(" </body>");

        printWriter.println("</html>");
    }
}

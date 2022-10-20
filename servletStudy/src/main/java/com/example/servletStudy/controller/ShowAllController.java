package com.example.servletStudy.controller;

import com.example.servletStudy.Utils.SqlSessionUtil;
import com.example.servletStudy.entity.User;
import com.example.servletStudy.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//转发：此处只有业务处理逻辑，然后将参数写入request，转发给返回页面
//若是只有管理员才能查看showallcontroller，需要通过session控制
@WebServlet("/showAllController")
public class ShowAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Object ob=session.getAttribute("manager");
        if (null!=ob){
            SqlSession sqlSession= SqlSessionUtil.getSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> userList= userMapper.selectAll();
            req.setAttribute("userList",userList);
            //转发
            req.getRequestDispatcher("/showjsp").forward(req,resp);
        }else {
            resp.sendRedirect("/servletStudy_war_exploded/loginMgr.html");
        }

    }
}

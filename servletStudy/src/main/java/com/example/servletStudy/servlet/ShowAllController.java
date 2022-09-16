package com.example.servletStudy.servlet;

import com.example.servletStudy.Utils.SqlSessionUtil;
import com.example.servletStudy.entity.User;
import com.example.servletStudy.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//转发：此处只有业务处理逻辑，然后将参数写入request，转发给返回页面

@WebServlet("/showAllController")
public class ShowAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList= userMapper.selectAll();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/showjsp").forward(req,resp);
    }
}

package com.example.servletStudy.servlet;

import com.example.servletStudy.Utils.SqlSessionUtil;
import com.example.servletStudy.entity.User;
import com.example.servletStudy.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 无需配置web.xml，用注解的方式进行servlet配置
 * 看看注解的代码，可以写value和urlpattern，这两个作用一样，并且可以配置多个
 * 还有个 loadOnStartup
 * 以后就不需要写web.xml了
 * */

@WebServlet(value = "/zhujie")
public class WebServletStudy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户请求的数据, 获取的就是form表单中的参数
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("post 提交的数据"+userName+"\t"+password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对request请求对象设置统一编码，为了解决乱码问题，因为浏览器传过来的数据是utf-8编码的，只有post需要解码，get不需要
        req.setCharacterEncoding("utf-8");

        //获取用户请求的数据, 获取的就是form表单中的参数
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("post 提交的数据"+userName+"\t"+password);
        //相应数据给客户端
        //设置服务端编码格式（不设置就中文乱码，设置浏览器端解码格式，一定要放在printWriter之前设置
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter= resp.getWriter();
        //printWriter.println("success");
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=userMapper.queryUser(userName);
        if (users.size()==1){
            User user=users.get(0);
            if (password.equals(user.getPASSWORD())){
                printWriter.println("登陆成功");
            }else {
                printWriter.println("登录失败，密码错误");
            }
        }else if (users.size()>1){
            printWriter.println("用户数据异常");
        }else {
            printWriter.println("用户未登录");
            printWriter.println("无此用户");
        }
        sqlSession.close();

    }
}

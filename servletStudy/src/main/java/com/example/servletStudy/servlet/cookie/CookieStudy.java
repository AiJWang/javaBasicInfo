package com.example.servletStudy.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Cookie study
 * 客户端存数据：cookie
 * 服务器存数据：session
 *
 * */
@WebServlet(value = "/cookiestudy")
public class CookieStudy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //前端的respHeader 就可以看见了
        Cookie cookie=new Cookie("usrName","waj");
        Cookie cookie1=new Cookie("pwd","123456");
        //cookie 默认不支持中文，所以需要编码与解码
        Cookie cookie2=new Cookie(URLEncoder.encode("姓名","utf-8"),URLEncoder.encode("张三","utf-8"));
        //设置cookie访问路径，只有在路径下的servlet才能用这个cookie
        cookie.setPath("/servletStudy_war_exploded");
        cookie1.setPath("/servletStudy_war_exploded");
        //cookie设置过期时间 0:浏览器关闭即过期   -1 内存存储（默认-1）  大于0：单位为秒
        cookie.setMaxAge(60*60);
        cookie1.setMaxAge(60*60);
        //cookie响应给客户端,可以添加cookie,cookie可添加多个
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);

    }
}

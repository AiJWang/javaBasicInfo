package com.example.ServletFinalPractise.filter;

import com.example.ServletFinalPractise.entity.EmpManager;
import com.example.ServletFinalPractise.mapper.EmpMapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(value = "/manager/safe/*")
public class FilterAll implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session= request.getSession();
        EmpManager empManager=(EmpManager)session.getAttribute("empManager");
        if (null!=empManager){
            filterChain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

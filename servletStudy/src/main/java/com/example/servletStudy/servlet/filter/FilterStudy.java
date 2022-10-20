package com.example.servletStudy.servlet.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器简介：
 *  客户端对服务器请求后，服务器调用servlet之前会经过一组过滤器（多个），这组过滤器称为过滤器链，存储在FilterChain中
 *  每个过滤器实现某个特定功能，当第一个Filter的doFilter方法被调用时，web服务器会创建一个代表filter链的Filterchain对象传递给该方法
 *  在doFilter方法中，如果调用了FilterChain对象的doFilter方法，则服务器会检查FilterChain中是否还有filter，如果有，则调用第二个filter
 *  如果没有，则调用目标资源（响应时也会经过多次）
 * 过滤器：
 *  1. 作用：客户端发送请求时，会先到达过滤器，然后到目标servlet，响应时，会根据执行流程反向执行
 *  2。可以解决多个servlet共性代码的冗余问题，如 乱码处理，登录验证
 * 过滤器实现过程：
 *  1. 编写java类实现Filter接口
 *  2. 在doFilter中编写业务代码
 *  3. 设置拦截路径
 *过滤器优先级：
 *  1. 如果都是采用注解方式，则按照类全名称的字符串顺序决定作用顺序
 *  2. 如果用的web.xml文件，则按照filter.mapping注册顺序，从上到下
 *  3. web.xml方式高于注解
 *  4. 如果注解和web.xml同时配置，会创建多个过滤器对象，造成多次过滤
 *
 *拦截路径的设置：
 *  1. 精确拦截：/index.jsp    /myservlet
 *  2. 后缀匹配拦截: *.jsp   *.html
 *  3. 通配符拦截匹配 /* 表示拦截所有请求，注意过滤器不能单独使用 / 匹配。/aa/bb/*允许
 * */

//设置要拦截的servlet
@WebFilter("/targetServlet")
public class FilterStudy implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my filter");
        //让请求去目标servlet
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("end");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

package cn.kgc.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet2
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/29 11:50
 * @Version 1.0
 */
public class MyServlet2 extends GenericServlet {

    @Override
    public void init() throws ServletException {
        String sex = getInitParameter("sex");
        System.out.println(sex);
        System.out.println("MyServlet2...初始化...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //session技术
        //servletRequest:处理所有请求 ： 方法少
        //HttpServletRequest:是专门处理http请求 : 方法更多
        //HttpServletResponse:是专门处理http响应
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.getSession();
        System.out.println("接收请求，处理请求，返回响应...");
    }
}

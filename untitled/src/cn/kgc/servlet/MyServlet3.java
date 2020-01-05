package cn.kgc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;
import java.io.IOException;

/**
 * @ClassName MyServlet3
 * @Description TODO  常用的方式
 * @Author zhaojing
 * @Date 2019/10/29 12:02
 * @Version 1.0
 */

public class MyServlet3 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    //接收请求，处理请求，返回响应
    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if(method.equals("get")){
            //处理get请求

        }else if(method.equals("post")){
            //处理Post请求

        }
    }*/

    //处理get请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletContext对象：tomcat运行期间有效=域对象
        //设置属性值
        request.getServletContext().setAttribute("name","tom");
    }

    //处理Post请求
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public void destroy() {

    }
}

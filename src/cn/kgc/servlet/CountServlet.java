package cn.kgc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/count") //注解，不需要在web.xml里面进行配置servlet servlet3.0版本以上才有的功能
//获取count进行显示
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取sevletContext中存放的count值，进行显示
        //第一次访问countServlet的时候，没有count属性值
        int count = 0; //初始化访问量是0
        Object countObj = request.getServletContext().getAttribute("count");
        if(countObj!=null){
            count = (int)countObj;
        }
        //在页面进行显示
        response.getWriter().write("<h1>当前登录用户的数量是："+count+"</h1>");
    }
}

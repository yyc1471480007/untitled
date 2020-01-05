package cn.kgc.servlet;

import cn.kgc.service.DemoService;
import cn.kgc.service.impl.DemoServiceImpl;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName MyServlet1
 * @Description TODO  创建一个servlet： 就是一个java类
 * @Author zhaojing
 * @Date 2019/10/29 9:53
 * @Version 1.0
 */
public class MyServlet1 implements Servlet {

    //创建service的对象
    DemoService demoService = new DemoServiceImpl();



    //初始化方法：servlet一创建就执行该方法。
    //该方法在整个的生命周期中只执行一次。
    //servletConfig:可以获取初始化的配置信息
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //getInitParameter:获取初始化的值
        String code = servletConfig.getInitParameter("code");
        System.out.println("code:"+code);
        System.out.println("MyServlet1...被创建了...");
        //count是访问量
        //获取ServletContext对象，设置Count属性，默认0  = 访问量0
        servletConfig.getServletContext().setAttribute("count",0);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    service方法：
       接收请求
       处理请求
       返回响应 的核心方法。
    该方法可以执行无数次。

    servletRequest:表示接收请求
    servletResponse：表示返回响应
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //处理中文乱码问题：
        //先处理请求的中文乱码
        servletRequest.setCharacterEncoding("utf-8");
        //处理响应的中文乱码
        servletResponse.setContentType("text/html;charset=utf-8");

        //接收请求
        //获取表单提交的用户名和密码
        //getParameter: 通过name属性，能够获取表单中的元素的值。
        //getParameter("name属性的值");
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        PrintWriter pw = servletResponse.getWriter();
        //处理请求  = 数据库操作 = 调用service层
        //验证用户名和密码是否正确！登录验证功能
        //1.如果验证成功，返回登录成功信息，显示用户名：尊贵的VIP会员【xxxx】，欢迎登录网站！！！
        //2.如果验证不成功，返回显示用户名和密码错误！！
        try {
            boolean b = demoService.isExists(username, password);
            if(b){
                //放用户登录成功时
                //1.先获取servletContext中存放的count值
                int count = (int)servletRequest.getServletContext().getAttribute("count");
                //2.累加数量
                count++;
                //3.把count设置回servletContext
                servletRequest.getServletContext().setAttribute("count",count);
                pw.write("<h1>尊贵的VIP会员【"+username+"】，欢迎登录网站！！！</h1>");
            }else{
                pw.write("<h1>用户名或者密码错误！</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回响应
        //通过输出流，把数据返回到浏览器
        //PrintWriter pw = servletResponse.getWriter();
        //把数据返回到浏览器
        //pw.write("<h1>我已成功接收到数据！</h1>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁方法
    /*
    * 该方法在servlet销毁之前执行。
    * */
    @Override
    public void destroy() {
        System.out.println("MyServlet1...被销毁了！");
    }
}

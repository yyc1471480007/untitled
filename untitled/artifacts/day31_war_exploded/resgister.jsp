<%--
  Created by IntelliJ IDEA.
  User: YYC
  Date: 2019/11/19
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            /*使用jquery的ajax异步请求*/
            /*ajax：jquery的基础的一个异步请求：jQuery 底层 AJAX 实现*/
            /*给用户名绑定失去焦点事件*/
            $(":text").blur(function () {
                var $username = $("#username").val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/ajaxJquery",
                    async:true,
                    data:{"username":$username},
                    dataType:"json",
                    type:"get",
                    success:function (data) {
                        console.log(data);
                        //data : {"msg":"恭喜你，可以注册！"}
                        $("span").html(data.msg);
                    },
                    error:function (data) {
                        $("span").html("服务器请求错误！");
                    }
                })
            })

        })
    </script>
</head>
<body>
    <h1>学生信息注册注册</h1>
    <form action="" method="get">
        学生名称：<input type="text" name="username" id="username"><span></span><br><br>
        密码：<input type="password" name="pwd1" id=""><br><br>
        确认密码：<input type="password" name="pwd2" id=""><br><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: YYC
  Date: 2019/11/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
    <script>
        alert("页面刷新");
        $(function () {
            $("#btn").click(function () {
                var $username = $("#username").val();
                //创建XMLHttpRequest核心对象
                var req = new XMLHttpRequest();
                //2.开启发送请求的通道
                //true:表示异步。false:表示同步
                req.open("post","${pageContext.request.contextPath}/ajaxPost",true);
                //设置post提交方式的请求头
                req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                //3.发送请求
                req.send("username="+$username);
                //4.调用回调函数，把服务器的数据响应到页面上
                req.onreadystatechange=function () {
                    //响应就绪
                    if (req.readyState==4&&req.status==200){
                        //接受
                        var msg = req.responseText;
                        $("#uid").val(msg);
                    }
                }
            })
        })
    </script>
</head>
<body>
    <h1>测试异步</h1>
    <input type="button" value="按钮" id="btn"><br>
    <form action="" method="post">
        用户名：<input type="text" name="username" id="username"><br><br>
        身份证号：<input type="text" name="uid" id="uid" value="${uid}"><br><br>
</body>
</html>

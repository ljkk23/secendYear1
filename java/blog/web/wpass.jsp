<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2021/12/12
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>wrong pass</title>
    <script>
        window.onload=function()
        {
            window.alert("密码错误！");
            var a=setTimeout("open('./index.jsp')","5000");
        }

    </script>
</head>
<body>
<h1 style="text-align: center;color: red">正在跳转到登录页面！</h1>

</body>
</html>

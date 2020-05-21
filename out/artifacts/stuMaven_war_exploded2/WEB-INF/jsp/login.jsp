<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
        <h1 align="center">登录</h1>

        <form action="login.html" method="post" align="center">
            <span>${error }</span>
            <div>
                <span>用户名：</span>
                <input type="text" name="name" required placeholder="请输入用户名"/>
            </div>
            <div>
                <span>密&nbsp;&nbsp;&nbsp;码：</span>
                <input type="text" name="passWord" required placeholder="请输入密码"/>
            </div>
            <div>
                <input type="submit" value="登录" />
            </div>
        </form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
</html>

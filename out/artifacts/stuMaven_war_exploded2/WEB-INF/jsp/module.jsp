<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <style type="text/css">

        #zuo{
            float: left;
        }
        #you{
            float: left;
        }
        #if{
            width:700px;
            height:500px;
        }
    </style>
<head>
    <title>首页</title>
</head>
<body>
<div id="zz">
    <div>学生奖惩管理系统|欢迎您，${user.userName }|<a href="${pageContext.request.contextPath }/zx">注销</a></div>
    <div id="zuo">
        <dl>
            <dt><a href="${pageContext.request.contextPath }/studentList" target="you">学生列表</a><dt>
            <dt><a href="${pageContext.request.contextPath }/list.html" target="you">奖惩管理</a><dt>
            <dt><a href="${pageContext.request.contextPath }/zx">退出系统</a><dt>
        </dl>
    </div>
    <div id="you">
        <iframe src="sy" name="you" id="if"></iframe>

    </div>
</div>
</body>
</html>

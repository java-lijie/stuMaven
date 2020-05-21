<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>通过学号奖惩查看页面</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>序号</td>
            <td>奖惩</td>
            <td>学生姓名</td>
            <td>创建人</td>
            <td>描述</td>
        </tr>
        <c:forEach items="${viewList }" var="viewlist">
            <tr>
                <td>${viewlist.id }</td>
                <td>${viewlist.name }</td>
                <td>${viewlist.student.name }</td>
                <td>${viewlist.createBy }</td>
                <td>${viewlist.des }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

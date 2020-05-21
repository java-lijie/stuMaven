<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<style>
    #vv{
        width:530px;
        height:150px;
    }
</style>
<head>
    <title>学生信息页面</title>
</head>
<body>
    <h1 align="center">学生信息</h1>
    <table align="center" border="1">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>职务</td>
            <td>专业</td>
            <td>班级</td>
            <td>性别</td>
            <td>生日</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${StudentList }" var="StudentList">
            <tr>
                <td>${StudentList.code }</td>
                <td>${StudentList.name }</td>
                <td>
                    <c:if test="${StudentList.job ==1}">
                        普通学生
                    </c:if>
                    <c:if test="${StudentList.job ==2}">
                        组长
                    </c:if>
                    <c:if test="${StudentList.job ==3}">
                        班长
                    </c:if>
                </td>
                <td>
                    <c:if test="${StudentList.major ==1}">
                        计算机
                    </c:if>
                    <c:if test="${StudentList.major ==2}">
                        电气
                    </c:if>
                    <c:if test="${StudentList.major ==3}">
                        金融
                    </c:if>
                </td>
                <td>${StudentList.grade }</td>
                <td>
                    <c:if test="${StudentList.sex ==1}">
                        男
                    </c:if>
                    <c:if test="${StudentList.sex ==2}">
                        女
                    </c:if>
                </td>
                <td><fmt:formatDate value="${StudentList.birthday }" pattern="yyyy-MM-dd"/></td>
                <td>${StudentList.tel }</td>
                <td><a href="${pageContext.request.contextPath }/view.html?stuCode=${StudentList.code }" target="vv">查看</a></td>
            </tr>

        </c:forEach>

    </table>
    <div align="center">
        <iframe src="" name="vv" id="vv"></iframe>
    </div>
</body>
</html>

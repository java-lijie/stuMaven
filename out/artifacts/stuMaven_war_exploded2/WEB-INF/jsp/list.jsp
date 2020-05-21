<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>奖惩管理页面</title>
</head>
<body>
<div align="center">
    <h1 align="center">奖惩管理</h1>
    <form method="post" action="${pageContext.request.contextPath}/listTj.html">
        <span>奖惩：</span>
        <input type="text" name="name">
        <span>学生姓名：</span>
        <input type="text" name="student.name">

        <input type="submit" value="查询">
        <a href="${pageContext.request.contextPath}/add.html?id=" target="you">添加</a>
    </form>
    <table border="1">
        <tr>
            <td>序号</td>
            <td>奖惩</td>
            <td>学生姓名</td>
            <td>创建人</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list }" var="list">
            <tr>
                <td>${list.id }</td>
                <td>${list.name }</td>
                <td>${list.student.name }</td>
                <td>${list.createBy }</td>
                <td><fmt:formatDate value="${list.createDate }" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/add.html?id=${list.id }" target="you">修改</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="javascript:;" class="sc" id="${list.id }" target="you">删除</a>
                </td>
            </tr>
        </c:forEach>
            </td>
        </tr>
    </table>

</div>
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}">
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script>
    $(function(){
        $("tr:odd").css("background-color","red");
        var path=$("#path").val();

        $(".sc").on("click",function(){
            if(confirm("确定要删除吗？")==true)
            {

                var obj = $(this);
                window.location.href=path+"/delete/"+obj.attr("id");
            }
        });
    });

</script>
</html>

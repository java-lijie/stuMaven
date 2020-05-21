<%--
  Created by IntelliJ IDEA.
  User: 李杰
  Date: 2020/5/12
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>奖惩修改页面</title>
</head>
<body>
<table border="1">
    <form  method="post" id="from">
    <c:forEach items="${list}" var="list">
        <input type="hidden" name="rid" value="${list.rid }"/>
        <input type="hidden" name="createDate" value="<fmt:formatDate value="${list.createDate }" pattern="yyyy-MM-dd HH:mm:ss" />" />
        <input type="hidden" name="createBy" value="${list.createBy }"/>
        <tr>
            <td>奖惩记录名：</td>
            <td><input type="text" name="name" id="name" value="${list.name }" required/></td>
            <td>
                <span class="title">*</span>
            </td>
        </tr>
        <tr>
            <td><span>奖惩对象：</span></td>
            <td>
                <select name="stuCode" id="stuCode" required>

                    <c:forEach items="${name }" var="name">
                        <c:choose>
                            <c:when test="${list.stuCode eq name.code }">
                                <option value="${name.code }" selected="selected">${name.name }</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${name.code }">${name.name }</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>描述：</td>
            <td><input type="text" name="des" value="${list.des }" required/></td>
        </tr>
        <tr>
            <td align="center" colspan="3">

                <input type="button" id="bc" value="保存"/>
                <input type="button" id="fh" value="取消"/>
            </td>
        </tr>
    </c:forEach>
    </form>
</table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script>

    $("#bc").click(function()
    {

        if(confirm("是否要提交数据"))
        {
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/addSave.html",
                data:$("#from").serialize(),
                dataType:"json",

                success:function(result)

                {

                    if(result.shu=="true")
                    {
                        window.location.href="${pageContext.request.contextPath}/list.html";
                    }else
                    {
                        alert("保存信息失败,请重新填写！");
                    }
                },
                error:function()
                {
                    alert("error：保存信息错误");
                }

            });
        }
    });
    $("#fh").click(function(){
        history.go(-1);
    });

</script>
</html>

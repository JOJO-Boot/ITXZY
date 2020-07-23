<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<body>
<font size="7">学员报名系统</font>
<br>
<hr>
<br>
<table align="center" border="1" cellpadding="10" cellspacing="0" width="1300px" >
    <!--align 对齐方式 -->
    <!--border 边框值-->
    <!--cellpadding 单元格内元素的间隔，即tr与tr之间的间隔-->
    <!--cellspacing 单元格内宽  ,     即单元格与tr之间的间隔-->
    <!--width 单元格宽度-->

    <!--http://blog.sina.com.cn/s/blog_7019362c0100n8yv.html-->
    <tr>
        <td>ID</td>
        <td>创建时间</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>职业</td>
        <td>城市</td>
        <td>加入时间</td>
        <td>毕业学校</td>
        <td>在线学号</td>
        <td>日报链接</td>
        <td>誓言</td>
        <td>师兄</td>
        <td>更新时间</td>
        <td>从知地</td>
    </tr>
    <c:forEach items="${studentList}" var="s">
     <!--item  要被循环的信息-->
        <tr>
            <td>${s.id}</td>
            <td>${s.createat}</td>
            <td>${s.name}</td>
            <td>${s.qq}</td>
            <td>${s.type}</td>
            <td>${s.city}</td>
            <td>${s.enterat}</td>
            <td>${s.school}</td>
            <td>${s.onlineid}</td>
            <td>${s.link}</td>
            <td>${s.desire}</td>
            <td>${s.bro}</td>
            <td>${s.updateat}</td>
            <td>${s.knowfrom}</td>

<%--            <td>--%>
<%--                <form method="post" action="${pageContext.request.contextPath}/student/${s.id}">--%>
<%--                    <input type="submit"  value="修改"/>--%>
<%--                </form>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <form method="post" action="${pageContext.request.contextPath}/student/${s.id}">--%>
<%--                    <input type="hidden" name="_method" value="DELETE">--%>
<%--                    <input type="submit"  value="删除"/>--%>
<%--                </form>--%>
<%--            </td>--%>
        </tr>

    </c:forEach>
</table>
</body>
</html>
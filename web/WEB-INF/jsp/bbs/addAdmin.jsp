<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/29
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${normalUser.size()==0}">
    <h2>尊敬的${showpost.groupid}群  <span style="color: red">${usering.posterName}</span> 群主,您的群组好像还没有普通成员,赶快找几个吧！</h2>
</c:if>
<c:if test="${normalUser.size()!=0}">
    <h2>尊敬的${showpost.groupid}群 <span style="color: red">${usering.posterName}</span> 群主,下面是该群的普通成员列表</h2>
    <table border="1" cellspacing="0" cellpadding="10" align="center">
        <tr>
            <td>普通成员ID</td>
            <td>普通成员员姓名</td>
            <td>群组ID</td>
            <td>群组名称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${normalUser}" var="normalUser">
            <tr>
                <td>${normalUser.adminid}</td>
                <td>${normalUser.adminName}</td>
                <td>${normalUser.groupid}</td>
                <td>${normalUser.groupname}</td>
                <td><a href="addAdmin?adminid=${normalUser.adminid}&groupid=${normalUser.groupid}">添加</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/29
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${adminlist.size()==0}">
    <h2>尊敬的${showpost.groupid}群  <span style="color: red">${usering.posterName}</span> 群主,您的群组好像还没有管理员,赶快找几个吧！</h2>
</c:if>
<c:if test="${adminlist.size()!=0}">
<h2>尊敬的${showpost.groupid}群 <span style="color: red">${usering.posterName}</span> 群主,下面是该群的管理员列表</h2>
    <table border="1" cellspacing="0" cellpadding="10" align="center">
        <tr>
            <td>管理员ID</td>
            <td>管理员姓名</td>
            <td>群组ID</td>
            <td>群组名称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${adminlist}" var="admin">
            <tr>
                <td>${admin.adminid}</td>
                <td>${admin.adminName}</td>
                <td>${admin.groupid}</td>
                <td>${admin.groupname}</td>
                <td><a href="deleteAdmin?adminid=${admin.adminid}&groupid=${admin.groupid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

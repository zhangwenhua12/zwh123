<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zwh
  Date: 2019/7/23
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课表显示</title>
</head>
<body>
<table border="1" cellspacing="0" align="center" style="width: 800px;">
    <tr>
        <td>节数/星期</td>
        <td>星期一</td>
        <td>星期二</td>
        <td>星期三</td>
        <td>星期四</td>
        <td>星期五</td>
        <td>星期六</td>
        <td>星期天</td>
    </tr>
    <c:forEach items="${sessionScope.course}" var="cou">
        <tr>
            <td>${cou.classNo}</td>
            <td>${cou.mon}</td>
            <td>${cou.tue}</td>
            <td>${cou.wed}</td>
            <td>${cou.thu}</td>
            <td>${cou.fri}</td>
            <td>${cou.sat}</td>
            <td>${cou.sun}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

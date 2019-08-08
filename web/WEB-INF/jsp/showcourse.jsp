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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <style>
        .a1{
            text-decoration: none;
            width: 120px;
        }
        .p1{
            width: 160px;
            border-radius: 10px;
            background-color: aquamarine;
            text-align: center;
            color: black;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
<div class="form-group " style="margin-left: 93px; margin-top: 80px; width: 100%;">
<span class="form-control btn-success col-1 d-block ml-5 mt-3 mb-3 float-left text-center" >
    <a href="/createCouser" style="text-decoration: none;" class="text-center text-gray-100">创建课表</a>
</span>

<c:if test="${sessionScope.flag}">

    <span class="form-control btn-success ml-3 mt-3 col-1 d-block  float-left text-center" >
        <a href="/tomodfiy" target="iframbody" style="text-decoration: none;" class="text-center text-gray-100">修改课表</a>
    </span>

    <span class="form-control  btn-success ml-3 mt-3  col-1 d-block float-left text-center">
        <a href="/deleteCouser" style="text-decoration: none;" class="text-center text-gray-100">删除课表</a>
    </span>
</c:if>
<c:if test="${sessionScope.flag}==false">
    <sapn style="display: none">
        <span class="p1"><a href="/tomodfiy" target="iframbody" class="btn-block btn-default">修改课表</a></span>
        <span class="p1"><a href="/deleteCouser" class="btn-block btn-default">删除课表</a></span>
    </sapn>
</c:if>
</span>
</div>
<div class="float-left " style="margin-left:125px;">
<table class="table table-bordered " border="1" cellspacing="0" align="center" style="width: 800px;text-align: center">
    <thead>
    <tr class="info">
        <th>节数/星期</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
        <th>星期六</th>
        <th>星期天</th>
    </tr>
    </thead>
    <c:forEach items="${sessionScope.course}" var="cou">
        <tr class="active">
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
</div>

</body>
</html>

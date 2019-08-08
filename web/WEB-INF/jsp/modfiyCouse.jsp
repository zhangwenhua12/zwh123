<%--
  Created by IntelliJ IDEA.
  User: zwh
  Date: 2019/7/24
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改课程</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <style>
        table{
            width: 800px;
            text-align: center;
            margin-top:200px;
        }
        input{
            width: 99px;
            border: none;
        }
        .btn {
            background-color: aqua;
            border-radius: 10px;
            box-shadow: none;
            border: none;
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>
<form method="post" action="/modfiyCouse" class="table-responsive">
<table class="table table-bordered" border="1" cellspacing="0" align="center" style="width: 800px;text-align: center">
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
        <tr class="text-center">
            <td class=" p-1 m-1" ><input  class="d-block " style="height: 34px;" type="text" value="${cou.classNo}" readonly="readonly"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;" type="text" value="${cou.mon}" name="mon${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input cclass="d-block " style="height: 34px;" type="text" value="${cou.tue}" name="tue${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;"  type="text" value="${cou.wed}" name="wed${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;" type="text" value="${cou.thu}" name="thu${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;"  type="text" value="${cou.fri}" name="fri${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;" type="text" value="${cou.sat}" name="sta${cou.classNo}"></td>
            <td class=" p-1 m-1" ><input class="d-block " style="height: 34px;"  type="text" value="${cou.sun}" name="sun${cou.classNo}"></td>
        </tr>
    </c:forEach>
    <tr >
        <td style="text-align: center" colspan="8"><input type="submit" value="提交" class="btn"></td>
    </tr>
</table>
</form>
</body>
</html>

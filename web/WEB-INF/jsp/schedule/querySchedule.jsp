<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/24
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <style>
        .btn {
            background-color: skyblue;
            border-radius: 10%;
            box-shadow: none;
            border: none;
            width: 100px;
            height: 30px;
        }

        table {
            margin-top: 200px;
        }
        .non-message{
            margin-top: 200px;
            height: 200px;
            text-align: center;
            padding-top: 50px;
        }
    </style>
</head>
<body>
<c:if test="${querylist.size()>0}">
    <form action="add.do" method="post">
        <table border="1" cellspacing="0" cellpadding="10" align="center" style="text-align: center;">
            <tr style="background-color: skyblue" >
                <td>考试科目</td>
                <td>考试时间</td>
                <td>考试备注</td>
                <td>考试地点</td>
                <td>创建的时间</td>
                <td>修改</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${querylist}" var="schedule">
                <tr>
                    <td>${schedule.examname}</td>
                    <td>${schedule.examtime}</td>
                    <td>${schedule.remark}</td>
                    <td>${schedule.examplace}</td>
                    <td>${schedule.createtime}</td>
                    <td><a href="update?studentid=${schedule.studentid}&examname=${schedule.examname}">修改</a></td>
                    <td><a href="delete?studentid=${schedule.studentid}&examname=${schedule.examname}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7" style="text-align: center">
                    <button class="btn">增加</button>
                </td>
            </tr>
        </table>
    </form>
</c:if>
<c:if test="${querylist.size()==0}">
    <form action="add.do">
            <div class="non-message">
                您的学习计划空空如也
            </div>
           <div style="text-align: center"><button class="btn">添加</button></div>
    </form>
</c:if>
</body>
</html>

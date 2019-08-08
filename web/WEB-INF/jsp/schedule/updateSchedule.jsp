<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/24
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .btn {
            background-color: skyblue;
            border-radius: 10%;
            box-shadow: none;
            border: none;
            width: 100px;
            height: 30px;
        }
        table{
            margin-top: 200px;
        }
    </style>
</head>
<body>
<form action="updateSchedule.do">
    <table border="0" align="center">
        <tr><td colspan="2" style="text-align: center"><h3>修改信息</h3></td></tr>
        <tr>
            <td>考试科目</td>
            <td><input type="text" name="examname"></td>
        </tr>
        <tr>
            <td>考试时间</td>
            <td><input type="text" name="examtime"> </td>
        </tr>
        <tr>
            <td>考试备注</td>
            <td><input type="text" name="remark"></td>
        </tr>
        <tr>
            <td>考试地点</td>
            <td><input type="text" name="examplace"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><button class="btn">提交</button></td>
        </tr>
    </table>
</form>
</body>
</html>

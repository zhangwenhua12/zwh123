<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/29
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${userinfo.name},发帖需要你完成下面几步操作</h2>
<form action="sendpost" method="post">
    <table>
        <tr>
            <td>topic</td>
            <td><input type="text" name="topic"></td>
        </tr>
        <tr>
            <td>content</td>
            <td><textarea name="content"></textarea></td>
        </tr>
        <tr>
            <td colspan="2"><button class="btn">发送</button></td>
        </tr>
    </table>
</form>
</body>
</html>

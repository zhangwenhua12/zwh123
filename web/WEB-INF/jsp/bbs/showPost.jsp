<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/28
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    <style>
            .content{
                width: 100px;
                height: 200px;
            }
        </style>--%>
</head>
<body>
<c:if test="${permissions == 0}">
</c:if>
<c:if test="${permissions == 1}">
    <a href="addpost">添加帖子</a>
    <a href="deletepost?postid=${showpost.postid}">删除帖子</a>
</c:if>
<c:if test="${permissions == 2}">
    <a href="addpost">添加帖子</a>
    <a href="deletepost?postid=${showpost.postid}">删除帖子</a>
    <a href="showadmin?groupid=${showpost.groupid}">删除管理员</a>
    <a href="showNormalAdmin?groupid=${showpost.groupid}">添加管理员</a>
</c:if>

<div class="content">
    <h2>${showpost.topic}</h2>
    <div>${showpost.content}</div>
    <div class="left">
        <c:forEach items="${showcomment}" var="comment">
            <div>${comment.commentcontent}</div>
        </c:forEach>
    </div>
    <div class="right">
        <c:forEach items="${showmycomment}" var="mycomment">
            <form action="deletemycomment?commentid=${mycomment.commentid}" method="post">
                <table>
                    <tr>
                        <td>${mycomment.commentcontent}</td>
                        <td>
                            <button class="btn">删除</button>
                        </td>
                    </tr>
                </table>
            </form>
        </c:forEach>
    </div>
</div>
<div class="foot">
    <form action="addcomment" method="post">
        <table>
            <tr>
                <td><input type="text" name="newcomment"></td>
                <td>
                    <button class="btn">确定</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

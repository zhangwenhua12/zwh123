<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 卢仕龙
  Date: 2019/7/28
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        body{
            background-color:  #F8F9FC;
        }
        /*#information {*/
        /*    background-color: #F8F9FC;*/
        /*}*/

        .info-content {
            border: 1px solid white;
            margin-bottom: 10px;
            padding: 10px 0;
            background-color: white;
        }

        .row {
            margin-left: 0;
            margin-right: 0;
        }

        .info-right {
            background-color: white;
            /*	margin-left: 10px;*/
            border: 1px solid white;
            /*padding-left:10px ;*/
        }
        .btn {
            background-color: skyblue;
            border-radius: 10%;
            box-shadow: none;
            border: none;
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>
<div id="information">
    <a href="/createGroup" >创建分组</a>
    <a>加入分组</a>
    <div class="container">
        <div class="row">
            <div class="col-md-4 info-left">
                <div class="container-fluid" style="padding:0; text-align: center">
                    <c:forEach items="${group}" var="group">
                        <div class="row info-content">
                            <form action="post.do?groupname=${group}" method="post">
                                <button class="btn">${group}</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-8 info-right hidden-xs hidden-sm">
                <div class="container-fluid">
                    <div class="row">
                        <c:if test="${post.size() == 0}">
                            <div>该群组还未有人发过贴,快快成为第一个发帖的吧！</div>
                            <c:if test="${permissions == 0}">
                                <div>不好意思,先生,您在该群组并不能发帖！</div>
                            </c:if>
                            <c:if test="${permissions > 0}">
                                <a href="addpost">添加帖子</a>
                            </c:if>
                        </c:if>
                        <c:if test="${post.size() != 0}">
                        <c:forEach items="${post}" var="post">
                        <div class="info-content" style="padding-right:0">
                            <h4><a href="post?topic=${post.topic}">${post.topic}</a></h4>
<%--                            <p>admin 15 / 10 / 11</p>--%>
                            <p>${post.content}</p>
                            <span>评论数:${post.commentnum}</span>
                            <span>发帖人:${post.posterName}&nbsp;&nbsp;发贴时间:${post.posttime}</span>
                        </div>
                        </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

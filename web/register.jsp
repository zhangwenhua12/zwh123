<%--
  Created by IntelliJ IDEA.
  User: zwh
  Date: 2019/7/26
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.js"></script>
    <style>
        .btn{
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
<div class="col-center-block"><h2>注册</h2>
<form action="/register.do" onsubmit="return checksubmit()" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">学号(学号将是您的用户名)</label>
        <div class="col-sm-3">
            <input id="username" onkeyup="existcheck()" name="username"  type="text" class="form-control">
            <span id="existcheck" style="font-size:14px;" ></span>
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input id="password" name="password"  type="password" class="form-control">
        </div>
    </div>

    <div class="form-group">
        <label for="passwordcheck" class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-3">
            <input id="passwordcheck" name="passwordcheck"  type="password" class="form-control">
        </div>
    </div>

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">学生姓名</label>
        <div class="col-sm-3">
            <input id="name" name="name" class="form-control" type="text">
        </div>
    </div>

    <div class="form-group">
        <label for="sex" class="col-sm-2 control-label">性别</label>
        <div class="col-sm-3">
            <select id="sex" name="sex" class="form-control">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">联系电话</label>
        <div class="col-sm-3">
            <input id="phone" name="phone" class="form-control" type="text">

        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">E-Mail</label>
        <div class="col-sm-3">
            <input id="email" name="email" class="form-control" type="email">

        </div>
    </div>
    <div class="form-group">
        <label for="collage" class="col-sm-2 control-label">所在学院</label>
        <div class="col-sm-3">
            <input id="collage" name="collage" class="form-control" type="text">

        </div>
    </div>
    <div class="form-group">
        <label for="major" class="col-sm-2 control-label">专业</label>
        <div class="col-sm-3">
            <input id="major" name="major" class="form-control" type="text">

        </div>
    </div>
    <div class="form-group">
        <label for="grade" class="col-sm-2 control-label">所在年级</label>
        <div class="col-sm-3">
            <select id="grade" name="grade" class="form-control">
                <option value="2018">2018</option>
                <option value="2017">2017</option>
                <option value="2016">2016</option>
                <option value="2015">2015</option>
                <option value="2014">2014</option>
                <option value="2013">2013</option>
                <option value="2012">2012</option>
                <option value="2011">2011</option>
                <option value="2010">2010</option>
            </select>

        </div>
    </div>
    <div class="form-group">
        <label for="classno" class="col-sm-2 control-label">班级</label>
        <div class="col-sm-3">
            <select id="classno" name="classno" class="form-control">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>

        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <button type="submit" class="btn" >提交注册</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <span id="msg" style="color:#F00;font-size:14px;text-align: center"></span>
        </div>
    </div>
</form>
</div>
</body>
</html>
<script type="text/javascript">
    var isexist;
    function checksubmit() {
        var emailcheck = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$", "").test($("#email").val());
        var passwordcheck = new RegExp("^[a-zA-z][a-zA-Z0-9]{5,16}$", "").test($("#password").val());
        var phonecheck = new RegExp("0?(13|14|15|18)[0-9]{9}", "").test($("#phone").val());
        var namecheck = new RegExp("[\u4e00-\u9fa5]", "").test($("#name").val());

        if($("#username").val() == "" || $("#passwordcheck").val() == "" || $("#password").val() == "" || $("#name").val() == ""
            || $("#collage").val() == "" || $("#major").val() == "" || $("#email").val() == "" || $("#phone").val() == ""){
            $("#msg").text("请填写完整信息");
            return false;
        }
        else if($("#password").val() != $("#passwordcheck").val()){
            $("#msg").text("两次输入密码不一致，请确认后输入");
            return false;
        }
        else if(isexist == true){
            $("#msg").text("此学号已注册 请确认后重试");
            return false;
        }
        else if(!passwordcheck){
            $("#msg").text("请输入6-16位由英文字母、数字和下划线组成的密码");
            return false;
        }
        else if(!emailcheck){
            $("#msg").text("请输入正确的邮箱");
            return false;
        }
        else if(!phonecheck){
            $("#msg").text("请输入正确的国内手机号");
            return false;
        }
        else if(!namecheck){
            $("#msg").text("请输入正确的姓名");
            return false;
        }
        else{
            $("#msg").text("");
            alert("注册成功 进入登录页面");
            return true;
        }

    }

    function existcheck() {
        $.ajax({
            data:{
                username:$("#username").val()
            },
            type:"post",
            url:"${pageContext.request.contextPath}/Checkname",
            error: function (data) {
                $("#msg").text("系统错误,请重试");
            },
            success: function (response) {
                if(response == "exist"){
                    isexist = true;
                    document.getElementById("existcheck").innerHTML="<font color='red'>此学号已存在, 请确认</font>";
                }
                else{
                    isexist = false;
                    document.getElementById("existcheck").innerHTML="<font color='green'>用户名可用</font>";
                }
            }
        });
    }
</script>

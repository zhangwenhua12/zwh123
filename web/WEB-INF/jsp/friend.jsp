
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/21
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.css" rel="stylesheet">
    <link href="/css/my.css" rel="stylesheet">
</head>
<body>


    <div class="dropdown col-3 ml-5 mt-5 pl-0 h-100 float-left">
        <span class="card-header d-block w-100">我的好友</span>
        <div class=" h-75 border " id="friendbuttond">
            <%--<span class="dropdown-item text-center small text-gray-500 d-block btn border-bottom" style="border-radius: 0px;" id="addfriend" style="height: 35px;" id="addfriend">添加好友</span>--%>
        <c:forEach items="${requestScope.friends}" var="item">
            <span class="dropdown-item d-flex align-items-center border-bottom">
                <div class="mr-3">
                    <div class="icon-circle bg-primary">
                        <i class="fas fa-file-alt text-white"></i>
                    </div>
                </div>


                <span aria-valuetext="/showFriendfile?friendid=${item.friendid}" class="btn" >
                    <span class="font-weight-bold">${item.friendid}</span>
                </span>


                <%--<div class="small text-gray-500 float-right">
                    <span id="lmessage" aria-valuetext="hah" class="btn" >留言</span>
                </div>--%>
            </span>
        </c:forEach>

        </div>
    </div>


    <div id="add" class="col-5 float-left mt-5 border p-0 ml-2 card">
        <span class="card-header" >添加好友</span>
        <form action="/addfriend" method="post" class="form-group card-body">
            <input type="text" name="friendid" id="inputaddfriend" class="form-control col-7 " placeholder="用户名"/><span id="message"></span>
            <input type="submit" value="添加" id="btnaddfriend"class="form-control col-4 mt-2"/>
        </form>
    </div>

    <div class="col-2 float-left border mt-5 border p-0 ml-lg-3" id="myfile">
        <span class="card-header w-100 d-block" id="con">某某的文件</span>
        <div  id="cbd">
        </div>
        <%--<c:forEach items="${requestScope.friendfiles}" var="item">
            <a class="d-block" style="height: 25px;" href="/showfriendhtml?filename=${item.filename}&fileowner=${item.username}">${item.filename}</a>
        </c:forEach>--%>
    </div>

   <%-- <div class="col-6 float-left mt-2 border p-0 ml-2 "  id="liuyan">
        <span class="card-header w-100 d-block" >给某某留言</span>
        <form class="form-group mr-auto">
            <input type="text" id="friendid" name="friendid" hidden>
            <div class="mt-1 ml-2 col-6">
                <span class="d-block form-control border-0 pr-1">主题</span>
                <input id="title" type="text" name="title" class="form-control">
            </div>
            <div class="mt-1 ml-2 col-10">
                <span class="d-block form-control border-0 pr-1">留言</span>
                <textarea name="" id="" cols="30" rows="8" name="content" class="form-control"></textarea>
            </div>
            <div class="mt-2 ml-2 col-3 ">
                <input type="button" value="发送" class="form-control  btn-success border">
            </div>
        </form>
    </div>--%>





<script src="/js/jquery-3.4.1.js"></script>
<script>

    $(function () {
        $("#addfriend").click(function(){
            console.log("nihao")
        });

       /* $("#yes").click(function(){
            console.log($(this).attr("aria-valuetext"));
            $("#leave").show();
        })*/

        $("div#friendbuttond span.btn").click(function () {
            console.log("div#friendbuttond span.btn");
            console.log($(this).attr("aria-valuetext"));
            $("#cbd").empty();
            $.ajax({
                type:"get",
                url:$(this).attr("aria-valuetext"),
                success:function(data){
                   var json= JSON.parse(data);
                    console.log(json.length);
                    console.log(json.files);
                    var files=json.files;
                    console.log(json.username);
                    $("#con").text(json.username+"的文件");
                   var file= files.toString().split(" ");
                   console.log(file[1]);
                    for(var i=0;i<file.length;i++){
                        var a="<a class=\"d-block\" style=\"height: 25px;\" href=\"/showfriendhtml?filename="+file[i] +"&fileowner="+json.username+"\">"+ file[i]+"</a>"
                        $("#cbd").append(a);
                    }
                }
            })
        });

        $("#inputaddfriend").blur(function(){
            $.ajax({
                type:"get",
                url:"/checkUsername",
                data:{
                    friendid:$(this).val()
                },
                success:function(data){
                    console.log("friend.jsp");
                    console.log(data);
                    var j=JSON.parse(data);
                    console.log(j.message);
                    $("#message").text(j.message);
                    console.log(j.message=="不存在用户");
                    if(j.message=="不存在用户"){
                        $("#btnaddfriend").attr("disabled",true);
                    }else{
                        $("#btnaddfriend").attr("disabled",false);
                    }

                }
            })
        })
    });
</script>
</body>
</html>

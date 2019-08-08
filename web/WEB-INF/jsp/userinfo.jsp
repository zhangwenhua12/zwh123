<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="../../css/sb-admin-2.css" rel="stylesheet">
    <link href="../../css/my.css">
</head>
<body>
<div class="container-fluid ">
<form id="allme">
    <div class="col-7 ml-auto mr-auto my-5">
        <div class="card mb-4 ">
            <div class="card-header">
                个人信息
            </div>

            <div class="card-body " style="float:left;">
                <div style="display: block">
                    <div class="card   border-left-info m-auto col-7 pt-1 pl-4" style="height:40px; display: block;">
                    <div class="card-body p-1 mb-2" style="height: 30px;">
                        <span class="mr-2 ">姓名</span>
                        <input type="text" name="username" id="username" value="${sessionScope.userinfo.name}"  style="border: none;">
                    </div>
                </div>

                <div class="card   border-left-info m-auto col-7 p-1 pl-4" style="height:40px;display: block;">
                    <div class="card-body p-1 mb-2" style="height: 40px;">
                        <span class="mr-2 ">性别</span>
                         <input type="text" name="sex" value="${sessionScope.userinfo.sex}"  style="border: none;">

                    </div>
                </div>

                <div class="card mb-2  border-left-info m-auto col-7 p-1 pl-4" style="height:40px;display: block;">
                    <div class="card-body p-1" style="height: 30px;">
                        <span class="mr-2 ">学院</span>
                             <input type="text" name="dep" value="${sessionScope.userinfo.collage}"  style="border: none;">
                    </div>
                </div>
                </div>
                <div class="card mb-2  border-left-info m-auto col-7 p-1 pl-4 d-block" style="height:40px; ">
                    <div class="card-body p-1" style="height: 30px;">
                        <span class="mr-2 ">年级</span>

                             <input type="text" name="cep" value="${sessionScope.userinfo.grade}" style="border: none;">

                    </div>
                </div>
                <div class="card mb-2 py-0 m-auto border-left-info col-7 p-1 pl-4 d-block" style="height:40px;">
                    <div class="card-body p-1" style="height: 30px;">
                        <span class="mr-2 ">专业班级</span>
                        <input type="text" name="major" value="${sessionScope.userinfo.major}"  style="border: none;width: 80px">

                        <input type="text" name="class1" value="${sessionScope.userinfo.classno}"  style="border: none;width: 60px">

                    </div>
                </div>

                <div class="card mb-2 py-0 border-left-info col-7 p-1 d-block pl-4 m-auto" style="height:40px;">
                    <div class="card-body p-1" style="height: 30px;">
                        <span class="mr-2 ">电话</span>

                              <input type="text" name="phone" value="${sessionScope.userinfo.phone}"  style="border: none;">

                    </div>
                </div>

                <div class="card mb-2 py-0 border-left-info col-7 p-1 d-block pl-4 m-auto" style="height:40px;">
                    <div class="card-body p-1" style="height: 30px;">
                        <span class="mr-2 ">邮件</span>
                        <input type="text" name="email" value="${sessionScope.userinfo.email}"  style="border: none;">
                    </div>
                </div>

            </div>
        </div>
        <div class="form-group m-auto col-3">
            <button  id="sub" class="btn-success form-control">修改</button>
        </div>
    </div>

</form>
</div>

</body>
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
</html>
<script type="text/javascript">
    $(function () {

        // $("#update").click(function () {
        //
        //     console.log($("#username").val());
        //     $('input').css("border","1px");
        // });

       $("#sub").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/update.do",
                type:"post",
                data:$("#allme").serialize(),
                success:function (result) {
                    // $('input').attr("readonly","readonly");
                }
            });

        })

    });
</script>

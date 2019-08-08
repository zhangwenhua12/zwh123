<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="../../css/sb-admin-2.css" rel="stylesheet">
    <link href="../../css/my.css">
    <link  charset="utf-8" href="/kindecitor/themes/default/default.css" type="text/css" rel="stylesheet">
    <script charset="utf-8" src="/kindecitor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="/kindecitor/zh-CN.js"></script>
    <script src="/js/jquery-3.4.1.js"></script>


</head>
<body>

    <div id="myfile" class="card">
        <span class="card-header bg-gradient-primary text-gray-100"  style="border-radius: 0px;">我的笔记</span>

        <div class="card-body mt-0 ml-0  p-0">
            <div class="list-group col-3 d-block float-left m-0 p-0 " style="border-radius: 0px;">
                <span onclick="newfile()" class="btn-block list-group-item" style="border-radius: 0px;">新建</span>
                <c:forEach items="${requestScope.files}" var="item">
                    <a href="/getNote?fileid=${item.id}" class="list-group-item list-group-item-light text-decoration-none">${item.filename}</a>
                </c:forEach>
            </div>

            <div class="float-left col-8 border-rad">
                <form  id="theeditor" action="/upNote" method="post" class="form-group ml-0 pl-0">
                    <input class="form-control ml-0 pl-0 border-success" type="text" hidden name="userid" style="border-radius: 0px;" value="<c:out value="${sessionScope.userinfo.username}"/>">
                    <input class="form-control ml-0 pl-0" type="text" hidden id="fileid" style="border-radius: 0px;" name="fileid" value="0"/>
                    <div class="col-3 float-left p-0 m-0 ">
                        <input class="form-control btn-facebook bg-gray-400" style="border-radius: 0px; height: 50px;" type="submit" value="提交" onclick="tijiao()"/>
                    </div>
                    <div class=" col-9 float-left p-0">
                        <input class="form-control col-6 d-block float-left" style="border-radius: 0px; height: 50px;" id="filename" type="text" name="filename" placeholder="文件名"/><span id="filem" class="col-6 float-left d-block pt-3 text-danger "></span>
                    </div>

                    <textarea  class="form-control border-top" name="content" id="content"></textarea>

                </form>
            </div>
        </div>
    </div>



<script>
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('#content', {
            width: '776px',
            height: '515px',
            allowPreviewEmoticons: true,
            filePostName: "uploadFile",
//这里就是指定文件上传的请求地址，上面也已经说了，upload_json.jsp就相当去一个servlet去进行保存文件，这个地方很重要
            uploadJson: '/myupload',
            resizeType:'0',
            allowImageUpload: true,
            items: [
                'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                'anchor', 'link', 'unlink', '|', 'about'
            ]
        });
    });

    function tijiao(){
        var str="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            editor.html()+"\n" +
            "</body>\n" +
            "</html>"
        console.log(str);
        console.log(editor.html());
    }

    function newfile(){
        $("#fileid").val("0");//表示新建文件
        console.log(theeditor.getAttribute("action"));
        var filename=document.getElementById("filename");
        filename.value="";
           /* editor.sync();*/
        editor.html("");
    }



    $(function(){

        $("#filename").blur(function(){//是否名称重复
            $.ajax({
                type:"get",
                url:"/checkfilename",
                data:{
                    filename:$(this).val(),//发送一个没有文件后后缀的文件名
                    username:${sessionScope.userinfo.username}
                },
                success:function(data){
                    var js=JSON.parse(data);
                    console.log(js.message);
                    $("#filem").html(js.message);
                }
            })
        })

        $("div#myfile a").click(function(){
            console.log($(this).attr("href"));
            var str=$(this).attr("href");
            console.log(str.split("=")[1]);

            $.ajax({
                type:"get",
                url:"/getNote",
                data:{
                    fileid:str.split("=")[1]//将a标签后面的文件id传递给/getNote。
                },
                success:function(data){
                    var jso=JSON.parse(data);
                    $("#filename").val(jso.filename);//设置文件名
                    editor.html(jso.content);
                    $("#fileid").val(str.split("=")[1]);//设置提交文件的id。
                }
            });
            return false;
        })
    })


</script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link  charset="utf-8" href="/kindecitor/themes/default/default.css" type="text/css" rel="stylesheet">
    <script charset="utf-8" src="/kindecitor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="/kindecitor/zh-CN.js"></script>

  </head>
  <body>
  <a href="/test">test</a>
  <textarea name="content" id="content">
    <h1>hahhha</h1>
  </textarea>



  <script>
      var editor;
      KindEditor.ready(function(K) {
          editor = K.create('#content', {
              width: '700px',
              height: '400px',
              allowPreviewEmoticons: true,
              filePostName: "uploadFile",
//这里就是指定文件上传的请求地址，上面也已经说了，upload_json.jsp就相当去一个servlet去进行保存文件，这个地方很重要
              uploadJson: '/upload_json.jsp',
              resizeType:'2',
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
  </script>
  </body>
</html>

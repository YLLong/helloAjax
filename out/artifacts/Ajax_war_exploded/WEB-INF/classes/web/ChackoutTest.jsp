<%--
  Created by IntelliJ IDEA.
  User: YLL
  Date: 2016/1/26
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Ajax 验证用户名 </title>

  <!--
  1、导入 jQuery 库
  2、获取 name=“username” 的节点：username
  3、为 username 添加 change 响应函数
  3.1、获取 username 的 value 属性值，去除前后空格且不为空。准备发送 Ajax 请求
  3.2、发送 Ajax 请求检验 username 是否可用
  3.3、在服务端直接返回一个 html 的片段：<font color="red">该用户已经被使用</font>
  3.4、在客服端浏览器把其直接添加到 #message 的 html 中
  -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
  <script type="text/javascript">
    $(function () {
      $(":input[name='username']").change(function () {
        var val = $(this).val();
        val = $.trim(val);
        if(val !="") {
          var url = "${pageContext.request.contextPath}/validateUsername";
          var args = {"userName":val, "time":new Date()};
          $.post(url, args, function (date) {
            $("#message").html(date);
          });
        }
      });
    });
  </script>
</head>
<body>
<form action="" method="get">
  用户名：<input type="text" name="username"/>
  <br>
  <div id="message"></div>
  <br>
  <input type="submit"/>
</form>
</body>
</html>

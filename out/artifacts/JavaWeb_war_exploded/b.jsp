<%--
  Created by IntelliJ IDEA.
  User: YLL
  Date: 2016/2/4
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎访问 B 页面</title>
</head>
<body>

<h4> BBB PAGE </h4>
<%
    //1、请求转发代码
//    request.getRequestDispatcher("/c.jsp").forward(request, response);

    //2、请求的重定向
    response.sendRedirect("c.jsp");
%>

</body>
</html>

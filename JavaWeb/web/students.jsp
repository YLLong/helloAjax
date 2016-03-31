<%@ page import="java.util.List" %>
<%@ page import="com.uiyllong.javaweb.javaBean.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: YLL
  Date: 2016/3/10
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%--<%= request.getAttribute("students") %>--%>
    <%--<br/>--%>
    <%--<%--%>
        <%--List<String> names = (List) request.getAttribute("students");--%>
        <%--for (String name: names) {--%>
    <%--%>--%>
            <%--<%=name%><br/>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
    %>
    <table border="1">
        <tr>
            <th>studentNo</th>
            <th>studentName</th>
            <th>sex</th>
            <th>birthday</th>
            <th>native</th>
            <th>nation</th>
            <th>classNo</th>
        </tr>

    <%
        for (Student student: students) {
    %>

            <tr>
                <td><%=student.getStudentNo()%></td>
                <td><%=student.getStudentName()%></td>
                <td><%=student.getSex()%></td>
                <td><%=student.getBirthday()%></td>
                <td><%=student.getNativ()%></td>
                <td><%=student.getNation()%></td>
                <td><%=student.getClassNo()%></td>
                <td><a href="deleteStudent?=<%=student.getStudentNo()%>">Delete</a></td>
            </tr>

    <%
        }
    %>
    </table>
</body>
</html>

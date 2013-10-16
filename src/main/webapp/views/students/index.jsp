<%@ page import="com.bestv.database.vo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bestv.database.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Student> students = DaoFactory.getStudentDao().findAll();
%>
<html>
<head>
    <title>学生管理系统 | 学生列表</title>
</head>
<body>
<table>
    <tr>
        <td>姓名</td>
        <td>学号</td>
        <td>班号</td>
    </tr>
    <%
        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getName() %></td>
        <td><%= student.getNumber() %></td>
        <td><%= student.getClassId() %></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/">返回首页</a>
</body>
</html>
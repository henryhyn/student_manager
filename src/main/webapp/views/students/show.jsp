<%@ page import="com.bestv.database.vo.Student" %>
<%@ page import="com.bestv.database.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : 0;
    Student student = DaoFactory.getStudentDao().find(id);
%>
<html>
<head>
    <title>学生管理系统 | 详情页面</title>
</head>
<body>
<table>
    <tr><td>姓名:</td><td><%= student.getName() %></td></tr>
    <tr><td>学号:</td><td><%= student.getNumber() %></td></tr>
    <tr><td>班号:</td><td><%= student.getClassId() %></td></tr>
</table>
<a href="/">返回首页</a> | <a href="/student?action=index">返回列表</a>
</body>
</html>
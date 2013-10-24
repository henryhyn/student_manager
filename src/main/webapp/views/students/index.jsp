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
        <td>操作</td>
    </tr>
    <%
        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getName() %></td>
        <td><%= student.getNumber() %></td>
        <td><%= student.getClassId() %></td>
        <td>
            <a href="/students/show?student.id=<%= student.getId() %>">查看</a>
            <a href="/students/edit?student.id=<%= student.getId() %>">修改</a>
            <a href="/students/destroy?student.id=<%= student.getId() %>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<a href="/">返回首页</a> | <a href="/students/add">新增学生</a>
</body>
</html>
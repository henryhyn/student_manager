<%--
  Created by IntelliJ IDEA.
  User: Henry
  Date: 15/9/4
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统 | 详情页面</title>
</head>
<body>
<table>
    <tr>
        <td>姓名:</td>
        <td>${student.name}</td>
    </tr>
    <tr>
        <td>学号:</td>
        <td>${student.number}</td>
    </tr>
    <tr>
        <td>班号:</td>
        <td>${student.classId}</td>
    </tr>
</table>
<a href="/">返回首页</a> | <a href="/students">返回列表</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统 | 详情页面</title>
</head>
<body>
<table>
    <tr><td>姓名:</td><td>${student.name}</td></tr>
    <tr><td>学号:</td><td>${student.number}</td></tr>
    <tr><td>班号:</td><td>${student.classId}</td></tr>
</table>
<a href="/">返回首页</a> | <a href="/students/index">返回列表</a>
</body>
</html>
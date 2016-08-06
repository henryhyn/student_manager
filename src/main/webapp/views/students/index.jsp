<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Henry
  Date: 15/9/2
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.number}</td>
            <td>${student.classId}</td>
            <td>
                <a href="/students/${student.id}">查看</a>
                <a href="/students/${student.id}/edit">修改</a>
                <a href="/students/${student.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/">返回首页</a> | <a href="/students/new">新增学生</a>
</body>
</html>

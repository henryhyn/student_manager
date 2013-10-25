<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.number}</td>
            <td>${student.classId}</td>
            <td>
                <a href="/students/show?student.id=${student.id}">查看</a>
                <a href="/students/edit?student.id=${student.id}">修改</a>
                <a href="/students/destroy?student.id=${student.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/">返回首页</a> | <a href="/students/add">新增学生</a>
</body>
</html>
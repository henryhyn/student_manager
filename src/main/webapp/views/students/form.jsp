<%--
  Created by IntelliJ IDEA.
  User: Henry
  Date: 15/9/4
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统 | ${student.id>0 ? "更新信息" : "新增学生"}</title>
    <%@ include file="/views/layouts/head.htm" %>
</head>
<body>
<form:form action="/students" method="post" modelAttribute="student">
    <div><form:hidden path="id"/></div>
    <div>姓名: <form:input path="name"/></div>
    <div>学号: <form:input path="number"/></div>
    <div>
        班级: <form:select path="classId">
        <form:option value="1">一班</form:option>
        <form:option value="2">二班</form:option>
        <form:option value="3">三班</form:option>
    </form:select>
    </div>
    <di><form:button>${student.id>0 ? "更新信息" : "新增学生"}</form:button></di>
</form:form>
</body>
</html>

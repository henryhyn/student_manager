<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
</head>
<body>
<jsp:include page="navbar.htm"/>
<h1>目录</h1>
<ul>
    <li><a href="/hello">Hello world!</a></li>
    <li><a href="/pages/henry/28">henry/28</a></li>
    <li><a href="/students">学生列表</a></li>
    <li><a href="/students.json">学生列表 (JSON)</a></li>
    <li><a href="/study/index">JSP 学习目录</a></li>
    <li><a href="/study/datetime">日期时间</a></li>
    <li><a href="/study/el">EL 表达式</a></li>
</ul>
<jsp:include page="footer.htm"/>
</body>
</html>

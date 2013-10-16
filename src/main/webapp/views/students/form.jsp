<%@ page import="com.bestv.database.vo.Student" %>
<%@ page import="com.bestv.database.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String action = request.getParameter("action") != null ? request.getParameter("action") : "create";
    Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : 0;
    String button = "新增学生";
    String name = "";
    String number = "";
    Integer classId = 0;
    if ("update".equals(action)) {
        Student student = DaoFactory.getStudentDao().find(id);
        name = student.getName();
        number = student.getNumber();
        classId = student.getClassId();
        button = "更新信息";
    }
%>
<html>
<head>
    <title>学生管理系统 | <%= button %></title>
</head>
<body>
<form action="/student?action=<%= action %>" method="post">
    <input hidden name="id" value="<%= id %>" />
    姓名: <input name="name" value="<%= name %>" /> <br/>
    学号: <input name="number" value="<%= number %>" /> <br/>
    班级: <select name="class_id">
        <option value="1" <%= classId==1 ? "selected" : "" %> >一班</option>
        <option value="2" <%= classId==2 ? "selected" : "" %> >二班</option>
        <option value="3" <%= classId==3 ? "selected" : "" %> >三班</option>
    </select>
    <button type="submit"><%= button %></button>
</form>
</body>
</html>
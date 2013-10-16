<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统 | 新增学生</title>
</head>
<body>
<form action="/student?action=create" method="post">
    姓名: <input name="name" /> <br/>
    学号: <input name="number" /> <br/>
    班级: <select name="class_id">
        <option value="1">一班</option>
        <option value="2">二班</option>
        <option value="3">三班</option>
    </select>
    <button type="submit">新增学生</button>
</form>
</body>
</html>
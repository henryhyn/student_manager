<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统 | ${student.id>0 ? "更新信息" : "新增学生"}</title>
</head>
<body>
<form action="/students/${student.id>0 ? "update" : "create"}" method="post">
    <input hidden name="student.id" value="${student.id}" />
    姓名: <input name="student.name" value="${student.name}" /> <br/>
    学号: <input name="student.number" value="${student.number}" /> <br/>
    班级: <select name="student.classId">
        <option value="1" ${student.classId==1 ? "selected" : ""} >一班</option>
        <option value="2" ${student.classId==2 ? "selected" : ""} >二班</option>
        <option value="3" ${student.classId==3 ? "selected" : ""} >三班</option>
    </select>
    <button type="submit">${student.id>0 ? "更新信息" : "新增学生"}</button>
</form>
</body>
</html>
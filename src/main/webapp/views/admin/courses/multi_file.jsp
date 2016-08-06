<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div align="center">
    <h1>上传多个附件</h1>

    <form method="post" action="/admin/courses/upload2" enctype="multipart/form-data">
        <input type="file" name="file1"/>
        <br/>
        <input type="file" name="file2"/>
        <input type="submit"/>
    </form>

</div>
</body>
</html>

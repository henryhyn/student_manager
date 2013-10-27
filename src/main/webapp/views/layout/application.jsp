<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="/assets/stylesheets/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/assets/stylesheets/font-awesome.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/assets/stylesheets/custom.css" media="all" rel="stylesheet" type="text/css" />
    <script src="/assets/javascripts/jquery.min.js" type="text/javascript"></script>
    <script src="/assets/javascripts/bootstrap.min.js" type="text/javascript"></script>
    <title></title>
</head>
<body>

<jsp:include page="navbar.htm"/>

<div class="container">
    <div class="main-row">
        <jsp:include page="${yield}"/>
    </div>
    <jsp:include page="footer.htm"/>
</div>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Date today = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = format.format(today);
    int hour = today.getHours();
    request.setAttribute("time", time);
    request.setAttribute("hour", hour);
%>
<html>
<head>
    <title>日期时间</title>
</head>
<body>
    当前时间为: ${time}. <br/>
    <c:choose>
        <c:when test="${hour>0 && hour<=5}">现在是凌晨! 时间还很早, 再睡会吧!</c:when>
        <c:when test="${hour>5 && hour<=10}">早上好! 新的一天即将开始, 你准备好了吗?</c:when>
        <c:when test="${hour>10 && hour<=13}">午休时间! 正好好时光!</c:when>
        <c:when test="${hour>13 && hour<=18}">下午继续努力工作吧!</c:when>
        <c:when test="${hour>18 && hour<=21}">晚上好! 自由时间!</c:when>
        <c:when test="${hour>21 && hour<=24}">已经是深夜了, 注意休息哦!</c:when>
        <c:otherwise>未知时间</c:otherwise>
    </c:choose>
</body>
</html>
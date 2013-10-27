<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>EL 表达式</h1>

<h2>EL 表达式概述</h2>

<p>
    <strong>表达式语言</strong> (Expression Language, EL), 简称 <strong>EL 表达式</strong>
</p>

<p>
    <strong>注意:</strong> EL 表达式至少需要支持 Servlet 2.4/JSP 2.0 的 Web 服务器.
</p>

EL 表达式的特点:
<ul>
    <li>可以访问一般变量.</li>
    <li>可以访问 JSP 内置对象.</li>
    <li>可以和 JSTL 标签库结合使用.</li>
    <li>可以执行关系、逻辑和算术等运算.</li>
</ul>

<h2>EL 表达式语法</h2>

EL 表达式的语法非常简单, 最大的特点是使用方便, 语法格式如下:
<pre>
\${expression}
</pre>

<p>
    当 EL 表达式中的变量没有指定范围时, 系统将默认从 page 范围开始查找,
    然后依次从 request、session 和 application 范围内查找.
    如果在这个过程中找到"expression"变量, 则直接返回, 否则返回 null.
</p>

<h2>EL 表达式运算</h2>

<ul>
    <li>取出数据</li>
    <li>算术运算</li>
    <li>关系运算</li>
    <li>逻辑运算</li>
    <li>empty 运算</li>
    <li>条件运算</li>
</ul>

<h1>JSTL 标签库</h1>

添加 jstl 依赖
<ul>
    <li>核心标签库</li>
    <ul>
        <li>表达式标签</li>
        <li>流程控制标签</li>
        <li>循环标签</li>
        <li>URL 操作标签</li>
    </ul>
    <li>格式标签库</li>
    <li>SQL 标签库</li>
    <li>XML 标签库</li>
    <li>函数标签库</li>
</ul>

</body>
</html>
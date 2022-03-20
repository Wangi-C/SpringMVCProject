<%--
  Created by IntelliJ IDEA.
  User: 2020A00160
  Date: 2022-03-14
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello1 페이지</h1>
<form action="/hello" method="post">
    이름 : <input type="text" name="name" id="name">
    이메일 : <input type="text" name="email" id="email">
    <input type="submit" value="제출하기"><br>
</form>
<h3>id : ${id}</h3>
</body>
</html>

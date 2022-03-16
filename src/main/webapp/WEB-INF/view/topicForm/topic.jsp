<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-16
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/topics" method="post">
    제목 : <input type="text" name="title" id="title">
    글 : <input type="text" name="contents" id="contents">
    <input type="submit" value="글 등록">
</form>

</body>
</html>

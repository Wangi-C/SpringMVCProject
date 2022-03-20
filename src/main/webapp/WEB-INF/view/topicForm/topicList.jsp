<%--
  Created by IntelliJ IDEA.
  User: 2020A00160
  Date: 2022-03-18
  Time: 오후 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글</title>
</head>
<body>
    <h2>게시글 들어올 자리.</h2>
    <hr>
    <form action="/topics">
        from : <input type="text" name="from"> ~
        to : <input type="text" name="to">
        <input type="submit" value="날짜 검색"><br>
    </form>
</body>
</html>

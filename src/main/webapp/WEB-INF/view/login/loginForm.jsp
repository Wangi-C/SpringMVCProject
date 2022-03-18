<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-18
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/logInOut" method="post">
    <c:if test="${loginCommand.isRememberId()}">
        id : <input type="text" name="id" id="id" value="${loginCommand.getId()}"><br>
    </c:if>
    <c:if test="${!loginCommand.isRememberId()}">
        id : <input type="text" name="id" id="id"><br>
    </c:if>
    pw : <input type="password" name="password" id="password"><br>
    <c:if test="${loginCommand.isRememberId()}">
        <input type="checkbox" name="rememberId" id="rememberId" checked="true">아이디 기억하기<br>
    </c:if>
    <c:if test="${!loginCommand.isRememberId()}">
        <input type="checkbox" name="rememberId" id="rememberId" value="true">아이디 기억하기<br>
    </c:if>
    <input type="submit" value="sign-in">
</form>
</body>
</html>

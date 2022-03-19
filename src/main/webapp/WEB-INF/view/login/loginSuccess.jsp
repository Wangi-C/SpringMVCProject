<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-03-18
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>완기 홈페이지</title>
</head>
<body>
    로그인을 성공했습니다.<br>
    <% String id = (String)session.getAttribute("id"); %>
    <%=id%>님, 환영합니다.
    <hr>
    <a href="/logInOut"><spring:message code="logout"/> </a>
</body>
</html>

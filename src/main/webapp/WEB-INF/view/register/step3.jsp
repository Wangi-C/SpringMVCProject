<%--
  Created by IntelliJ IDEA.
  User: 2020A00160
  Date: 2022-03-15
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <p>
        ${registerRequest.name}
        회원 가입을 축하드립니다.
    </p>
    <p>
        <a href="/register/step1"> 첫 화면으로 이동</a>
    </p>
</body>
</html>

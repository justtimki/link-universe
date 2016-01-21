<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: timki
  Date: 21.01.2016
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Parse from : ${mainLink}</h1>
<c:forEach items="${validLinks}" var="link">
    <p>${link}</p>
</c:forEach>
</body>
</html>

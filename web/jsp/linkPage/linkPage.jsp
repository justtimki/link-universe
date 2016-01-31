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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/LinkPage.css">
    <script src="${pageContext.request.contextPath}/js/LinkPage.js"></script>
    <title>Title</title>
</head>
<body>
<h1>Parse from : ${mainLink}</h1>
<div class="planet-container">
    <c:forEach items="${validLinks}" var="link">
        <div class="planet">
            <a href="#">${link}
                <script type="text/javascript"> setCircleSize("${link}")</script>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>


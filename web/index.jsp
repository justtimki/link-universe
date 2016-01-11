<%--
  Created by IntelliJ IDEA.
  User: timki
  Date: 07.01.2016
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/Site.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
</head>
<body>
<h1 class="title">Link <span class="thin">Universe</span></h1>

<div class="form-input">
    <form action="controller" method="post">
        <input type="text" name="linkField" placeholder="enter your link here">
        <span class="go-block hovicon effect-5 sub-a"><button class="go-button" type="submit">Go</button></span>
    </form>
</div>
<canvas id="demo-canvas"></canvas>
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<c:set var="lang" value="${request.lang}" scope="session"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="textForLogin"/>
<html>
<head>
    <style>
        .div_login{
            text-align: center;
        }
    </style>
    <title>Login</title>
</head>
<body>
<div>
    <a href="/part2_lesson2_war/login?lang=de">de</a>
    <a href="/part2_lesson2_war/login?lang=it">it</a>
</div>
<div class="div_login">
    <form method="post" action="/part2_lesson2_war/login">
        <p><fmt:message key="tfl.message"/> </p>
        <br>
        <div>
        <label><strong><fmt:message key="tfl.login"/></strong></label>
        <input type="text" name="login"/>
        </div>
        <br>
        <div>
        <label><strong><fmt:message key="tfl.password"/></strong></label>
        <input type="password" name="password"/>
        </div>
        <br>
        <button type="submit"><fmt:message key="tfl.send.button"/></button>
    </form>

</div>
</body>
</html>

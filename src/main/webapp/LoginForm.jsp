<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<h1>Залогинься</h1>
<form action="${pageContext.request.contextPath}/JavaCal" method="post">
    <label for="login">Логин:</label>
    <input type="text" name="login" id="login" value="${login}">
    <label for="pass">Пароль: </label>
    <input type="text" name="pass" id="pass" value="${pass}">
    <input type="submit" name="sign" value="Войти">
</form>
</body>
</html>

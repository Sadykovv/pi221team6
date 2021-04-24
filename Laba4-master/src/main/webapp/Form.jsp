<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор - вычисление периметра равнобедренного треугольника</title>
</head>
<body>
<h1>Калькулятор - вычисление периметра равнобедренного треугольника (в миллиметрах)</h1>
    <form action="${pageContext.request.contextPath}/JavaCalc" method="post">
        <label for="first">Длина основания(мм):</label>
        <input type="text" name="first" id="first" value="${first}">
        <label for="second">Длина боковой стороны(мм): </label>
        <input type="text" name="second" id="second" value="${second}">
        <input type="submit" name="sign" value="Calculate">
    </form>
    </body>
</html>
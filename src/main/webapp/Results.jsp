<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат вычисления периметра</title>
</head>
<body>
<h1>Результат вычисления периметра:</h1>
<h2>Ваши введеные данные:</h2>
<p><strong>Длина основания:</strong> ${first_result}</strong>(мм.)</p>
<p><strong>Длина боковой стороны:</strong> ${second_result}</strong>(мм.)</p>
<p><strong>Результат:</strong> ${result}</strong>(мм.)</p>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input type="submit" name="sign" value="Назад">
    </form>

</body>
</html>
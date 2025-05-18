<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário</title>
</head>
<body>
	<h1>Enviar Mensagem</h1>
	<form method="POST" action="request-body">
		Nome: <input type="text" name="nome"><br> <br>
		Email: <input type="email" name="email"><br> <br>
		Mensagem:<br>
		<textarea name="mensagem" rows="5" cols="40"></textarea>
		<br> <br>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>

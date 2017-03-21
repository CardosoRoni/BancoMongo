<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados Cadastrais</title>
</head>
<body>
<form action="Cadastroservlet" method="post">
<b>
<br/>Digite o número da sua conta: <input type="text"name="numeroConta"/>
<br/>
<br/>Digite seu nome completo:     <input type="text"name="nome"/>
<br/>
<br/>Digite o número do seu CPF:   <input type="text"name="cpf">
<br/>
<br/>Digite sua Renda mensal:      <input type="text"name="renda">
<br/>
<br/>Crie uma senha:               <input type="text"name="senha">
<br/>
</b>
<br/> <input type="submit" value="Confirma">
</form>
</body>
</html>
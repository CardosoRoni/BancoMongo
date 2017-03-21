<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Acesso</title>
</head>
<body>
<form action="OperacaoServlet" method="post">
<b>
<select name="operacao" id="operacao">
<option value="C">Credito
<option value="D">Debito 
</select>
<br/>
<br/>
<br>Valor:<input type="text" name="valor">
<br>
<br/>
<input type="submit" value="Enviar">
</b>
</form>
</body>

</html>

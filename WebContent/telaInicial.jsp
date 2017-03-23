<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Inicial</title>
</head>
<body>
	<form action="MainBancoServlet" method="post">
		<b> Entre com o numero da conta: <input type="text" name="conta" />
			<br /> <br /> Digite sua senha: <input type="text" name="senha" /> <br />
			<br />
		<input type="submit" value="Entrar"> <br /> <br />ou <a
			href="cadastro.jsp">Cadastre-se aqui</a>
		</b>
	</form>
</body>
</html>
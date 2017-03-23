package BancoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import BancoDAO.ContaDAO;
import BancoDAO.ContaDAOMongo;
import BancoModel.Conta;

/**
 * Servlet implementation class MainBancoServlet
 */
@WebServlet("/MainBancoServlet")
public class MainBancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainBancoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PrintWriter writer = response.getWriter();
		String conta = request.getParameter("conta");
		String senha = request.getParameter("senha");

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);

		Long numConta = Long.valueOf(conta);
		Conta c = dao.getConta(numConta);

		Integer nconta = c.getNumero();
		Integer convConta = Integer.valueOf(conta);
		String lsenha = c.getSenha();

		// if(nconta != null & lsenha !=null){

		if (nconta.equals(convConta) && lsenha.equals(senha))
			request.setAttribute("conta", conta);

		// response.getWriter().append("");

		// }else{ writer.println("<SCRIPT language='JavaScript'>alert('Preencha
		// o Valor');</SCRIPT> ");

		getServletContext().getRequestDispatcher("/telaAcesso.jsp").forward(request, response);

	}
}

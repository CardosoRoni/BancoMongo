package BancoServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import BancoDAO.ContaDAO;
import BancoDAO.ContaDAOMongo;
import BancoModel.Cliente;
import BancoModel.Conta;


@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numeroConta = request.getParameter("numeroConta");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String renda = request.getParameter("renda");
		String senha = request.getParameter("senha");
		
		if (numeroConta.equals("") && nome.equals("") && cpf.equals("") && renda.equals("")) {
			response.getWriter().append("");
		} else {
			MongoClient mongo = new MongoClient();
			DB db = mongo.getDB("contas");
			ContaDAO contaDAO = new ContaDAOMongo(db);

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setCpf(Integer.valueOf(cpf));
			cliente.setRenda(Double.valueOf(renda));

			Conta conta2 = new Conta();
			conta2.setNumero(Integer.valueOf(numeroConta));
			conta2.setCliente(cliente);
			conta2.setSenha(senha);
			conta2.setSaldo(Double.valueOf(renda));

			contaDAO.inserir(conta2);

			mongo.close();
			response.getWriter().append("Cliente cadastrado com sucesso!");
			response.sendRedirect("telaAcesso.jsp");
		
	
	}
	}

}
package BancoServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

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
		//PrintWriter writer = response.getWriter();
		String numeroConta = request.getParameter("numeroConta");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String renda = request.getParameter("renda");
		String senha = request.getParameter("senha");

		
		
		if(numeroConta!=null & nome!= null & cpf != null & renda != null & senha !=null) {
		
		//if (numeroConta.equals("") & nome.equals("") & cpf.equals("") & renda.equals("")) {
			
		} else {
			MongoClient mongo = new MongoClient();// criando um clienteMongo
			DB db = mongo.getDB("contas");// seleciona o banco no caso "contas"
			ContaDAO contaDAO = new ContaDAOMongo(db);// o DAO onde gerencia as
														// informaçoes 

			Cliente cliente = new Cliente();// cria um cliente normal
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setRenda(Double.valueOf(renda));

			Conta conta1 = new Conta();// cria conta normal pq conta tem que ter
										// um cliente
			conta1.setNumero(Integer.valueOf(numeroConta));
			conta1.setCliente(cliente);
			conta1.setSenha(senha);
			conta1.setSaldo(Double.valueOf(renda));
			contaDAO.inserir(conta1);// metodo que salva no banco
			mongo.close();// fecha conexao
			request.setAttribute("conta", conta1);
			response.sendRedirect("telaInicial.jsp");// abre a proxima pagina

		}
	}

}
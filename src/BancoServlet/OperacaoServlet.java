package BancoServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import BancoModel.Operacao;
import BancoModel.tipoOperacao;



/**
 * Servlet implementation class OperacaoServlet
 */
@WebServlet("/OperacaoServlet")
public class OperacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OperacaoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		String valor = request.getParameter("valor");
		String numConta = request.getParameter("conta");

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);
		
	    Long conta = Long.valueOf(numConta);
		Conta contaNum = new Conta();
		contaNum = dao.getConta(conta);
		
		Date data = new Date();
		
		
		Double saldo= contaNum.getSaldo();
		double oprValor= Double.valueOf(valor);
		
		Operacao opr = new Operacao();
		opr.setValor(Double.valueOf(valor));
		opr.setData(data);

		if (operacao.equals("") || operacao == null) {
		} else if (operacao.equalsIgnoreCase("C")) {
			opr.setTipoOperacao(TipoOpr.CREDITO);
			saldo += oprValor;

			contaNum.setSaldo(saldo);
			dao.update(contaNum);
		} else if (operacao.equalsIgnoreCase("D")) {
		if(saldo<=oprValor){
			
		}else{ 
			saldo -= oprValor;
			contaNum.setSaldo(saldo);
			opr.setTipoOperacao(TipoOpr.DEBITO);
		}
		}
		
		List<Operacao>contaList= contaNum.getOperacaoList();
		contaList.add(opr);
		contaNum.setOperacaoList(contaList);
		dao.update(contaNum);
		response.sendRedirect("telaInicial.jsp");

		
	}

}

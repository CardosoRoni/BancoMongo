package BancoServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.mongodb.DB;
import com.mongodb.MongoClient;

import BancoDAO.ContaDAO;
import BancoDAO.ContaDAOMongo;
import BancoModel.Conta;
import BancoModel.Operacao;



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
		String op = request.getParameter("op");
		String valor = request.getParameter("valor");
		String conta = request.getSession().getAttribute("conta").toString();

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);
		// Encontra a contra que a pessoa está utilizando
		Conta contaNum = new Conta();
		contaNum = dao.getConta(conta);

		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		dt.format(new Date());

		// auxiliar para calculo de saldo
		Double saldo = 0.0;
		// Registra a operação realizada
		Operacao opr = new Operacao();
		opr.setValor(Double.valueOf(valor));
		opr.setData(dt);

		if (op.equals("") || op == null) {
			response.getWriter().append("Operação inválida! tente novamente");
			response.sendRedirect("menu.jsp");
		} else if (op.equals("credito")) {
			// Utilizando o ENUM para definir como constante o nome da operação
			opr.setTipoOpr(String.valueOf(TipoOpr.CREDITO));
			saldo += Double.valueOf(valor);

			contaNum.setSaldo(saldo);
			dao.update(contaNum);
		} else if (op.equals("debito")) {
			opr.setTipoOpr(String.valueOf(TipoOpr.DEBITO));

			saldo -= Double.valueOf(valor);
			contaNum.setSaldo(saldo);
			dao.update(contaNum);
		}

		request.getSession().setAttribute("saldo", saldo);
		response.sendRedirect("telaAcesso.jsp");
	}

}

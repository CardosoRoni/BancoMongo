package BancoServlet;

import java.io.IOException;

/**
 * Servlet implementation class MainBancoServlet
 */
@WebServlet("/MainBancoServlet")
public class MainBancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainBancoServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("conta");String senha = request.getParameter("senha");
	

		if (login.equals("") && senha.equals("")) {
			response.getWriter().append("");
		} else {
			request.getSession().setAttribute("conta", login);
			response.getWriter().append("");
			response.sendRedirect("telaAcesso.jsp");


	}
	}
}

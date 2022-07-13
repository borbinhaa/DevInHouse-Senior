

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio02
 */
@WebServlet("/exercicio02")
public class Exercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		
		for (Empresa empresa : BancoDeEmpresas.getListaEmpresas()) {
			out.println("<li>" + empresa.getNome() + " - " + empresa.getCnpj() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}

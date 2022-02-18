

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaPessoa
 */
@WebServlet("/listapessoa")
public class ListaPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Pessoa> lista = banco.listar();
		System.out.println(lista);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		
		for (Pessoa pessoa: lista) {
			out.println("<li>" + pessoa.getNome() + "</li>");			
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	}

}

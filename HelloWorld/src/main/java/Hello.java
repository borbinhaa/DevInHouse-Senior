import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		PrintWriter out = resp.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Hello World");
//		out.println("</body>");
//		out.println("</html>");
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String nome = req.getParameter("nome");
		System.out.println(nome);
		
	}
}

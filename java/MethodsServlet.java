import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/methods")
public class MethodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Métodos suportados: GET, POST, PUT, DELETE, OPTIONS</h1>");
    }
}

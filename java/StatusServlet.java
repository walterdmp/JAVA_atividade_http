import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String code = req.getParameter("code");
		PrintWriter out = resp.getWriter();

		try {
			int status = Integer.parseInt(code);
			resp.setStatus(status);
			out.println("<h1>Status HTTP: " + status + "</h1>");
		} catch (Exception e) {
			resp.setStatus(400);
			out.println("<h1>Código inválido</h1>");
		}
	}
}

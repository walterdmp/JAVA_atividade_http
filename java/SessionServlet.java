import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Cookie[] cookies = req.getCookies();
		String usuario = null;

		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("usuario".equals(c.getName())) {
					usuario = c.getValue();
					break;
				}
			}
		}

		if (usuario != null) {
			out.println("<h1>Bem-vindo de volta, usuário '" + usuario + "'</h1>");
		} else {
			Cookie novo = new Cookie("usuario", "X");
			novo.setMaxAge(60 * 60 * 24);
			resp.addCookie(novo);
			out.println("<h1>Cookie criado: usuário 'X'</h1>");
		}
	}
}
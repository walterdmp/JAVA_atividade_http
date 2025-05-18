import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h1>Cabeçalhos da Requisição</h1>");

		String userAgent = req.getHeader("User-Agent");
		out.println("<p><strong>Navegador (User-Agent):</strong> " + userAgent + "</p>");

		String referer = req.getHeader("Referer");
		out.println("<p><strong>Página de origem (Referer):</strong> "
				+ (referer != null ? referer : "Nenhuma (acesso direto)") + "</p>");

		String acceptLanguage = req.getHeader("Accept-Language");
		out.println("<p><strong>Linguagem preferida (Accept-Language):</strong> " + acceptLanguage + "</p>");

		String acceptEncoding = req.getHeader("Accept-Encoding");
		out.println("<p><strong>Codificações aceitas (Accept-Encoding):</strong> " + acceptEncoding + "</p>");

		String ip = req.getRemoteAddr();
		out.println("<p><strong>IP do usuário:</strong> " + ip + "</p>");

		String httpVersion = req.getProtocol();
		out.println("<p><strong>Versão HTTP utilizada:</strong> " + httpVersion + "</p>");
	}
}

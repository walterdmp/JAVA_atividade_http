import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request-body")
public class RequestBodyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		BufferedReader reader = req.getReader();
		StringBuilder corpo = new StringBuilder();
		String linha;
		while ((linha = reader.readLine()) != null) {
			corpo.append(linha).append("\n");
		}

		out.println("<!DOCTYPE html><html><head><title>Corpo da Requisição</title></head><body>");
		out.println("<h1>Corpo da Requisição Recebida</h1>");
		out.println("<pre>" + corpo.toString() + "</pre>");
		out.println("</body></html>");
	}
}

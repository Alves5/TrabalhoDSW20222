package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/numeroJogo")
public class JogoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		int rand = (int)(Math.random()*5);
		String resultado;
		System.out.println(rand);
		if(numero == rand) {
			resultado = "Você acertou!";
		}else {
			resultado = "Você errou!";
		}
		/* BancoDeDados.insert(j); */
		//Gerar a p�gina dinamicamente
		PrintWriter escritor = resp.getWriter();
		escritor.write("<html>");
		escritor.write("<head><title>Lista de jogos</title></head>");
		escritor.write("<body>");
		escritor.write("<h1>"+resultado+"</h1>");
		escritor.write("<br/><a href=\"index.html\">voltar</a>");
		escritor.write("</body>");
		escritor.write("</html>");
	}
}

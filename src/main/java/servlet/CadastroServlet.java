package servlet;

import static util.DataUtil.formatar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.BancoDeDados;
import entidades.Cadastro;
@WebServlet(urlPatterns = "/cadastroServlet")
public class CadastroServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cadastro c = new Cadastro();
		c.setVariavel1(req.getParameter("variavel1"));
		c.setVariavel2(req.getParameter("variavel2"));
		
		//Inserindo no "Banco de Dados"
		BancoDeDados.insert(c);
		
		//Gerar a p�gina dinamicamente
				PrintWriter escritor = resp.getWriter();
				escritor.write("<html>");
				escritor.write("<head><title>Lista de jogos</title></head>");
				escritor.write("<body>");
				escritor.write("Data: " + formatar(new Date()));
				escritor.write("<br/>Lista de variaveis<br/>");
				escritor.write("<table>");
				escritor.write("<thead><tr><th>Variavel 1</th><th>Variavel 2</th></tr></thead>");
				escritor.write("<tbody>");
				escritor.write(BancoDeDados.select());
				escritor.write("</tbody>");
				escritor.write("</table>");
				escritor.write("<br/><a href=\"index.html\">voltar</a>");
				escritor.write("</body>");
				escritor.write("</html>");
	}
}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
				escritor.write("<!DOCTYPE html>");
				escritor.write("<head>");
				escritor.write("<meta charset=\"ISO-8859-1\">");
				escritor.write("<title>Lista de vacinas</title>");
				escritor.write("</head>");
				escritor.write("<body>");
				escritor.write("<h1/>Lista de vacinas<h1/>");
				escritor.write("<ol>"+BancoDeDados.select()+"</ol>");
				escritor.write("<br/><a href=\"index.html\">voltar</a>");
				escritor.write("</body>");
				escritor.write("<script>window.onload = function lancarMensagem(){alert(\"Vacinas cadastradas com sucesso!\")}</script>");
				escritor.write("</html>");
	}
}

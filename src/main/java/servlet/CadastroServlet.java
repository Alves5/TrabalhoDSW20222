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
		c.setLuva(req.getParameter("luva"));
		c.setMascara(req.getParameter("mascara"));
		
		//Inserindo no "Banco de Dados"
		BancoDeDados.insert(c);
		
		//Gerar a p�gina dinamicamente
				PrintWriter escritor = resp.getWriter();
				escritor.write("<!DOCTYPE html>");
				escritor.write("<head>");
				escritor.write("<meta charset=\"ISO-8859-1\">");
				escritor.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"><title>Lista de vacinas</title>");
				escritor.write("</head>");
				escritor.write("<body style=\"background: #6C7A89;\">");
				escritor.write("<a class=\"linkVoltar\" id=\"linkCadastro\" href=\"index.html\">voltar</a>");
				escritor.write("<div class=\"listaOrdenada\">");
				escritor.write("<div><h1>Lista de vacinas</h1></div>");
				escritor.write("<div class=\"boxOrdenada\">");
				escritor.write("<ol>"+BancoDeDados.select()+"</ol>");
				escritor.write("</div></div>");
				escritor.write("</body>");
				escritor.write("<script>window.onload = function lancarMensagem(){alert(\"EPIs cadastrados com sucesso!\")}</script>");
				escritor.write("</html>");
	}
}

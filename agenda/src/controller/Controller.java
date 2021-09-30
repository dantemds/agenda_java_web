package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/// response.getWriter().append("Served at: ").append(request.getContextPath());
		/// não serve mais

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);

		}else if (action.equals("/insert")) {
			novocontato(request, response);
		}else {
			response.sendRedirect("index.html");
		}

		/*
		 * teste de conexao
		 * 
		 * 
		 * 
		 * dao.testeconexao();
		 * 
		 * 
		 * 
		 */

	}

	/* listar contatos */

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
		
		/*Criando obj para receber os dados JavaBeans*/
		ArrayList<JavaBeans> lista = dao.listarContatos();

	}
	
	
	
	
	
	
	
	
	
	/*novo contato*/
	protected void novocontato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		/* inserir contato */
		dao.inserirContato(contato);
		/*redirecionar para agenda.jsp*/
		response.sendRedirect("main");
		
	}
	
	
	
}

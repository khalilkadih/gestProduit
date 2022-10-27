package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplimentatioProduit;
import dao.Iproduit;
@WebServlet(name="gestProduit",urlPatterns= {"/controleur","*.com"})
public class ControleurServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Iproduit metier;
	
	@Override
	public void init() throws ServletException {
		metier=new ImplimentatioProduit();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("ProduitJsp.jsp").forward(req, resp);
	}

	
	
}

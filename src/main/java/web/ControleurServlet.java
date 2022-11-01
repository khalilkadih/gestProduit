package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplimentatioProduit;
import dao.Iproduit;
import metier.entite.Produit;
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
		String path=req.getServletPath();
		if(path.equals("/index.com")) {
			req.getRequestDispatcher("ProduitJsp.jsp").forward(req, resp);
		}
		else if(path.equals("/chercher.com")) {	
			String motCle=req.getParameter("motcle");
			ModelProduit model=new ModelProduit();
			model.setMotRechercher(motCle);
			List<Produit> produit=metier.produitChercher("%"+motCle+"%");
			model.setProduits(produit);
			req.setAttribute("model",model);
			
			req.getRequestDispatcher("ProduitJsp.jsp").forward(req, resp);

		}else if(path.equals("/ajouter.com")) {
			
			req.getRequestDispatcher("/ajouterProduit.jsp").forward(req, resp);
			
		}else if(path.equals("/save.com")&& (req.getMethod().equals("POST"))){
			String designation=req.getParameter("designation");
			Double prix= Double.parseDouble(req.getParameter("prix"));
			int quantite= Integer.parseInt(req.getParameter("quantite"));
			Produit p= metier.save(new Produit(designation,prix,quantite));
			req.setAttribute("produit", p);
			req.getRequestDispatcher("confiramtionSave.jsp").forward(req, resp);
			}
		else if(path.equals("/delet.com")) {
			Long id=Long.parseLong(req.getParameter("id"));
			metier.deleteProduit(id);
			//req.getRequestDispatcher("/produitJsp.com").forward(req, resp);
			resp.sendRedirect("chercher.com?motcle=");
		}
		else if(path.equals("/update.com")) {
			Long id=Long.parseLong(req.getParameter("id"));
			Produit p=metier.getProduit(id);
			req.setAttribute("produit",p); 
			req.getRequestDispatcher("editProduit.jsp").forward(req, resp);
		}
		else
		{
			resp.sendError(resp.SC_NOT_FOUND);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
	
}

package fr.eni.ihm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.EnchereManager;
import fr.eni.bll.UserManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.*;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/enchere")
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date dateDuJour = new Date();
		EnchereManager mger = new EnchereManager();
		HttpSession session=request.getSession();
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		ArticleVendu article = (ArticleVendu)session.getAttribute("article");
		String prixEnchere = request.getParameter("prix_enchere");
		int montantEnchere;
		
		montantEnchere = Integer.parseInt(prixEnchere);
		
		Enchere enchere = new Enchere ( 
				dateDuJour,
				montantEnchere, 
				utilisateur, 
				article);
		
		enchere = mger.insert(enchere);
	        System.out.println(enchere);
	        
	        request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

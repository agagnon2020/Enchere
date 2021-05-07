package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bo.Utilisateur;
import fr.eni.bll.UserManager;

/**
 * Servlet implementation class inscription
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupération des informations entrés dans le formulaire pour créer un utilisateur en bdd
		
		Utilisateur utilisateur = new Utilisateur( request.getParameter("pseudo"), 
												request.getParameter("nom"), 
												request.getParameter("prenom"), 
												request.getParameter("email"), 
												request.getParameter("telephone"), 
												request.getParameter("rue"), 
												request.getParameter("code_postal"), 
												request.getParameter("ville"),  
												request.getParameter("mot_de_passe"), 
												100, 
												false);
		
		
		//Appeler la BLL pour inscrire l'utilisateur
		UserManager mger = new UserManager();
		Utilisateur userDal = new Utilisateur();
		userDal = mger.inscrire(utilisateur);
		System.out.println(userDal);
		HttpSession session = request.getSession();
		if(userDal.getNo_utilisateur() != 0) {
			session.setAttribute("utilisateur", userDal);
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request,response);
	
		
			//response.sendRedirect("/Enchere/accueil");
	
		
	}

}

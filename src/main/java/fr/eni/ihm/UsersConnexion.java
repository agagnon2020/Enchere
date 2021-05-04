package fr.eni.ihm;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.UserManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class UsersConnexion
 */
@WebServlet("/UsersConnexion")
public class UsersConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher JSP
		request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request,response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Etape 1 : Récupération des infos
		String identifiant = request.getParameter("identifiant");
		
		HttpSession session=request.getSession();
		
		//Users u= (Users)session.getAttribute("utilisateur");
		//Integer id = u.getNo_utilisateur();
		//session.setAttribute("no_utilisateur", id);
		
		System.out.println("Identifiant :"+ identifiant);
		
		String mot_de_passe = request.getParameter("mot_de_passe");
		
		System.out.println("Mot de passe :"+ mot_de_passe);
		
		//Traiter les infos
		UserManager mger = new UserManager();
		Utilisateur utilisateur  = mger.authentifier(identifiant, mot_de_passe);

		
		if(utilisateur != null) {
			//Soit l'utilisateur est connu et le mot de passe est correct
			//Afficher la page d'accueil
			response.sendRedirect("/Encheres/Accueil");
			session.setAttribute("utilisateur", utilisateur);
		}else {
			//Soit l'utilisateur ou le mot de passe n'est pas correct
			//On reste sur la meme page et on affiche un msg d'erreur
			request.setAttribute("erreur", "Votre identifiant ou votre mot de passe est incorrect");
			request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request,response);
			
		}
		
	}
	

}

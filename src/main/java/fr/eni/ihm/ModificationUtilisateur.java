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
 * Servlet implementation class ModificationUtilisateur
 */
@WebServlet("/ModificationUtilisateur")
public class ModificationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Utilisateur u= (Utilisateur)session.getAttribute("utilisateur");
		Integer id = u.getNo_utilisateur();
		
		UserManager mger = new UserManager();
		Utilisateur utilisateur  = mger.infosProfil(id);
		
		session.setAttribute("utilisateur", utilisateur);
		
		request.getRequestDispatcher("/WEB-INF/jsp/ModificationUtilisateur.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 récupérer la clef primaire de l'utilisateur courant
		HttpSession session = request.getSession();
		Utilisateur utilisateurOld = (Utilisateur) session.getAttribute("utilisateur");
		Integer clefPrimaire = utilisateurOld.getNo_utilisateur();
		
		//2 créer un nouvel utilisateur avec les nouvelles infos avec la clé primaire de l'ancien utilisateur
		//Utilisateur utilisateurNew = new Utilisateur(request.getParameter("identifiant"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"), request.getParameter("mot_de_passe"), 100, false);
		//utilisateurNew.setNo_utilisateur(clefPrimaire);
		
		//3 sauvegarder la donnée
		
		UserManager mger = new UserManager();
		//mger.modifierProfil(utilisateurNew);
		
		
			
			response.sendRedirect("/Encheres/Accueil");
			
			
	}

}

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
 * Servlet implementation class ModificationUtilisateurServlet
 */
@WebServlet("/ModifierProfil")
public class ModificationUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/ModificationUtilisateur.jsp").forward(request,response);
		HttpSession session=request.getSession();
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Utilisateur utilisateur= (Utilisateur)session.getAttribute("utilisateur");
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone(request.getParameter("telephone")); 
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setCode_postal(request.getParameter("code_postal"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setMot_de_passe(request.getParameter("mot_de_passe"));
		
		UserManager mger = new UserManager();
		mger.modifierProfil(utilisateur);
		session.setAttribute("utilisateur", utilisateur);
		response.sendRedirect("/Enchere/accueil");
	}

}

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
@WebServlet("/modification")
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
		if( request.getParameter("pseudo") != "" ) utilisateur.setPseudo(request.getParameter("pseudo"));
		if( request.getParameter("nom") != "" ) utilisateur.setNom(request.getParameter("nom"));
		if( request.getParameter("prenom") != null ) utilisateur.setPrenom(request.getParameter("prenom"));
		if( request.getParameter("email") != null ) utilisateur.setEmail(request.getParameter("email"));
		if( request.getParameter("telephone") != null ) utilisateur.setTelephone(request.getParameter("telephone")); 
		if( request.getParameter("rue") != null ) utilisateur.setRue(request.getParameter("rue"));
		if( request.getParameter("code_postal") != null ) utilisateur.setCode_postal(request.getParameter("code_postal"));
		if( request.getParameter("ville") != null ) utilisateur.setVille(request.getParameter("ville"));
		if( request.getParameter("mot_de_passe") != null ) utilisateur.setMot_de_passe(request.getParameter("n_mot_de_passe"));
		
		UserManager mger = new UserManager();
		mger.modifierProfil(utilisateur);
		session.setAttribute("utilisateur", utilisateur);
		response.sendRedirect("/Enchere/accueil");
	}

}

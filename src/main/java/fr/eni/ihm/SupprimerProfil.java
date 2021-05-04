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
 * Servlet implementation class SupprimerProfil
 */
@WebServlet("/SupprimerProfil")
public class SupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		Integer clefPrimaire = utilisateur.getNo_utilisateur();
		utilisateur.setNo_utilisateur(clefPrimaire);
		
		UserManager mger = new UserManager();
		//mger.supprimerProfil(utilisateur);
		
		request.setAttribute("suppression", "Votre profil utilisateur à bien été supprimé de notre base de donnée. Créer un nouveau compte si vous souhaitez vous reconnecter.");
		request.getRequestDispatcher("/WEB-INF/jsp/SupprimerProfil.jsp").forward(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

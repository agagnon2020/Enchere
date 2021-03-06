package fr.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Accueil sur le site avec attribution d'une session utilisateur
		HttpSession session=request.getSession();
		Utilisateur u= (Utilisateur)session.getAttribute("utilisateur");
		if(u != null) {
			String message=u.getNom();
			request.setAttribute("msgJSP", message);
			request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

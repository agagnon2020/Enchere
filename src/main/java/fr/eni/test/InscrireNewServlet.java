package fr.eni.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UserManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class InscrireNewServlet
 */
@WebServlet(name = "InscrireNewServletTest", urlPatterns = { "/InscrireNewServletTest" })
public class InscrireNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscrireNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur user1 = new Utilisateur("JeanChristopheDu06", "Jean", "Christophe", "jean.christophe@gmail.com", 06, "Rue jean", 44000, "Nantes", "mdpmdp", 100, false);
		Utilisateur user2 = new Utilisateur("JeanCharleDu35", "Jean", "Charle", "jean.charle@gmail.com", 06, "Rue jean", 35000, "Rennes", "mdpmdp2", 100, true);
		Utilisateur user3 = new Utilisateur("MarieChristine", "Marie", "Christine", "mpariechristine@gmail.com", 06, "Avenue de la vie", 01010, "La Lune", "mdpmdp3", 100, false);
		UserManager manager = new UserManager();

		
		manager.inscrire(user1);
		//manager.inscrire(user2);
		//manager.inscrire(user3);
		//System.out.println(manager.infosProfil(user1.getNo_utilisateur()));
		//System.out.println(manager.infosProfil(user2.getNo_utilisateur()));
		//System.out.println(manager.infosProfil(user3.getNo_utilisateur()));
		//manager.supprimerProfil(user1.getNo_utilisateur());
		//user1.setPseudo("MichelDu33");
		//System.out.println(manager.infosProfil(user1.getNo_utilisateur()));
		//manager.modifierProfil(user1);
		//System.out.println(manager.infosProfil(user1.getNo_utilisateur()));
		
		//System.out.println(manager.authentifier("MichelDu33", "mdpmdp"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

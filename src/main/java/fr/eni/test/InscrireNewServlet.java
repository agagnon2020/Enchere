package fr.eni.test;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.UserManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
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
		Utilisateur user1 = new Utilisateur("jeancri", "Jean", "Christophe", "jean.christophe123@gmail.com", "06", "Rue jean", "44000", "Nantes", "mdpmdp", 100, false);
		//Utilisateur user2 = new Utilisateur("JeanCharleDu35", "Jean", "Charle", "jean.charle@gmail.com", "06", "Rue jean", "35000", "Rennes", "mdpmdp2", 100, true);
		//Utilisateur user3 = new Utilisateur("MarieChristine", "Marie", "Christine", "mpariechristine@gmail.com", "06", "Avenue de la vie", "01010", "La Lune", "mdpmdp3", 100, false);
		//UserManager manager = new UserManager();

		
		//manager.inscrire(user1);
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
		user1.setNo_utilisateur(7);
		Categorie categorie = new Categorie(1, "lavabo");

		Date datdeb = new Date(2020, 10, 20);
		Date datfin = new Date(2021, 10, 20);
		ArticleVendu art1 = new ArticleVendu(120, 0, "Lavabo", "rouge", "bof", datdeb, datfin, user1, categorie);
		ArticleManager artM = new ArticleManager();
		artM.insert(art1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

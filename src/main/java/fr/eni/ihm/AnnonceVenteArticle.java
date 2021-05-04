package fr.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import fr.eni.bll.ArticleManager;
import fr.eni.bll.UserManager;
import fr.eni.bo.Utilisateur;
//import fr.eni.javaee.enchere.bo.Article;
//import fr.eni.javaee.enchere.bo.Users;

/**
 * Servlet implementation class AnnonceVenteArticle
 */
@WebServlet("/AnnonceVenteArticle")
public class AnnonceVenteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceVenteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Utilisateur u= (Utilisateur)session.getAttribute("utilisateur");
		Integer id = u.getNo_utilisateur();
		
		UserManager mger = new UserManager();
		Utilisateur utilisateur  = mger.infosProfil(id);
		
		session.setAttribute("utilisateur", utilisateur);
		
		request.getRequestDispatcher("/WEB-INF/jsp/AnnonceVenteArticle.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		/*Article article = (Article) session.getAttribute("article");*/		
		session.getAttribute("utilisateur");
		//int no_utilisateur= session.
		
		//Article article = new Article();
		
		//ArticleManager mger = new ArticleManager();
		//mger.enregistrerArticle(article);
		
		 //request.setAttribute("enregistrementArticle", "Votre article a bien été enregistré !");
		//response.sendRedirect("http://localhost:8080/Encheres/Accueil");
		
	}

}

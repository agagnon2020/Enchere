package fr.eni.ihm;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import fr.eni.bll.ArticleManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class FicheArticleServlet
 */
@WebServlet("/ficheArticle")
public class FicheArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int idArticle = Integer.valueOf(request.getParameter("article"));
		ArticleManager artM = new ArticleManager();
		ArticleVendu article = artM.informationArticle(idArticle);
		ServletContext context=getServletContext();
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		String dateDeb = format1.format(article.getDateDebutEncheres());
		String dateEnd = format1.format(article.getDateFinEncheres());
		
		context.setAttribute("articleNom", article.getNomArticle());
		context.setAttribute("articleDescription", article.getDescription());
		context.setAttribute("articlePrix", Integer.toString(article.getMiseAPrix()).concat(" points"));
		context.setAttribute("articleDateDebut", dateDeb);
		context.setAttribute("articleDateFin", dateEnd);
		context.setAttribute("articleCategorie", article.getCategorie().getLibelle());
		context.setAttribute("articleVendeur", article.getVendeur().getPseudo().toString());
		context.setAttribute("articleRue", article.getVendeur().getRue());
		context.setAttribute("articleVille", article.getVendeur().getVille());
		context.setAttribute("articleCodePostal", article.getVendeur().getCode_postal());
		request.getRequestDispatcher("/WEB-INF/jsp/FicheArticle.jsp").forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

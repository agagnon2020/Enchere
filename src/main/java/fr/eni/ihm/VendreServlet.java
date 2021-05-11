package fr.eni.ihm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class VendreServlet
 */
@WebServlet("/vente")
public class VendreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/VenteArticle.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		
        String nbCredit = request.getParameter("prix_article");
        String dateDebut = request.getParameter("debut_vente");
        String dateFin = request.getParameter("fin_vente");
        Date dateDebutVente = new Date(
        		Integer.parseInt(dateDebut.substring(6))-1900, 
        		Integer.parseInt(dateDebut.substring(3,5))-1, 
        		Integer.parseInt(dateDebut.substring(0,2))
        		);
        
        Date dateFinVente = new Date(
        		Integer.parseInt(dateFin.substring(6))-1900, 
        		Integer.parseInt(dateFin.substring(3,5))-1, 
        		Integer.parseInt(dateFin.substring(0,2))
        		);

        Date dateActuelle = new Date();
        
        System.out.println(dateActuelle);
        System.out.println(dateDebutVente);
        System.out.println(dateFinVente);
        
        
        if(Integer.valueOf(nbCredit) <= 0) {
            request.setAttribute("erreur", "Le prix de l'article ne peut pas être égale ou inférieure à 0");
            request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
            System.out.println("Je suis au premier cas");
        }
        if(dateDebutVente.before(dateActuelle)) {
            request.setAttribute("erreur", "La date de début doit être supérieure ou égale à la date du jour");
            request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
            System.out.println("Je suis au deuxième cas");
        }
        if(dateDebutVente.after(dateFinVente)) {
            request.setAttribute("erreur", "La date de début doit être inférieure à la date de fin");
            request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
            System.out.println("Je suis au troisième cas");
        }
        if(dateDebutVente.equals(dateFinVente)) {
            request.setAttribute("erreur", "La date de début et la date de fin ne peuvent être égales");
            request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
            System.out.println("Je suis au dernier cas");
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp").forward(request,response);
	}

}

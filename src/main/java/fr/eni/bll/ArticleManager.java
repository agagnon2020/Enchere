package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.BusinessException;
import fr.eni.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO dao;
	
	public ArticleManager() {
		this.dao = DAOFactory.getArticleDAO();
	}
	
	//Retournerla liste des articles en vente Page Accueil 
	public List<ArticleVendu> ListeDesArticles() {
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		try {
			listeArticles = dao.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return listeArticles;
	}
	
	// Enregistrer un nouvel article pour un utilisateur
	public ArticleVendu insert(ArticleVendu article) {
		boolean erreur = false;
		
		if(!(article.getMiseAPrix()<= 0)) {
			erreur =true;
		}
		
		Date dateJour = new Date();
		Date dateDeb = article.getDateDebutEncheres();
		Date dateFin = article.getDateFinEncheres();
		
		dateJour.compareTo(dateDeb); //dateJour < dateDeb, renvoie un négatif
		dateDeb.compareTo(dateFin); //date2 > date1, renvoie un positif

		if(!dateJour.before(dateDeb) || dateJour.equals(dateDeb)){
			erreur =true;
			
		}
		if (!dateDeb.after(dateFin) || dateDeb.equals(dateFin)) {
			erreur =true;
		}
		if(erreur == false) {
			try {
				return dao.insert(article);
			} catch (BusinessException e) {
				e.printStackTrace(); }
		}else {
			article.setNoArticle(0);
			return article;
		}
		return null;
	}
	
		
	// Modifier un article 
	public void updateArticle(ArticleVendu article) {

			try {
				dao.insert(article);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

	}
		
	// Supprimer un article
		public void deleteArticle(int id) {

			try {
				dao.deleteArticle(id);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

	}
		
		public ArticleVendu informationArticle(int id) {
			ArticleVendu article = null;
			
			try {
				article = dao.selectById(id);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			return article;
		}
		
		public List<ArticleVendu> rechercheArticles(String name){
			List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
			
			try {
				listeArticles = dao.searchName(name);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			return listeArticles;
		}
		
		public List<ArticleVendu> rechercheCategorie(String name){
			List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
			
			try {
				listeArticles = dao.searchCategory(name);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			return listeArticles;
		}

}

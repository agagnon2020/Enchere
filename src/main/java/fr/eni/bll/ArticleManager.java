package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticles;
	}
	
	// Enregistrer un nouvel article pour un utilisateur
	public ArticleVendu insert(ArticleVendu article) {

		try {
			return dao.insert(article);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return article;
	}
		
	// Modifier un article 
	public void updateArticle(ArticleVendu article) {

			try {
				dao.insert(article);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
		
	// Supprimer un article
		public void deleteArticle(int id) {

			try {
				dao.deleteArticle(id);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}

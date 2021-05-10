package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleDAO;
import fr.eni.dal.BusinessException;
import fr.eni.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO dao;
	
	public ArticleManager() {
		this.dao = DAOFactory.getArticleDAO();
	}
	
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
}

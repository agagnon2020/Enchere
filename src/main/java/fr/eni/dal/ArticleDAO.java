package fr.eni.dal;

import java.util.List;

import fr.eni.bo.ArticleVendu;

public interface ArticleDAO {
	public ArticleVendu insert(ArticleVendu article) throws BusinessException;
	public List<ArticleVendu> selectAll() throws BusinessException;
	public ArticleVendu selectById(int id) throws BusinessException;
	public void deleteArticle(int idArticle) throws BusinessException;
	public void updateArticle(ArticleVendu article) throws BusinessException;
}
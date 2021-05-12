package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Enchere;

public interface EnchereDAO {
	public Enchere insert(Enchere enchere) throws BusinessException;
	public List<Enchere> selectAll() throws BusinessException;
	public Enchere selectById(int id) throws BusinessException;
	public void deleteEnchere(int idEnchere) throws BusinessException;
	public void updateEnchere(Enchere enchere) throws BusinessException;
	public Enchere selectBest(int idArticle) throws BusinessException;
}

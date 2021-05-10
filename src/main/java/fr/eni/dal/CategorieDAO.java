package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Categorie;

public interface CategorieDAO {
	public Categorie insert(Categorie categorie) throws BusinessException;
	public List<Categorie> selectAll() throws BusinessException;
	public Categorie selectById(int id) throws BusinessException;
	public void deleteCategorie(int idCategorie) throws BusinessException;
	public void updateCategorie(Categorie categorie) throws BusinessException;
}

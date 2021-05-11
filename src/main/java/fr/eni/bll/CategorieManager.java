package fr.eni.bll;

import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.BusinessException;
import fr.eni.dal.CategorieDAO;
import fr.eni.dal.DAOFactory;

public class CategorieManager {
	private CategorieDAO dao;

	public CategorieManager() {
		this.dao = DAOFactory.getCategorieDAO();
	}
	
	public Categorie informationCategorie(int id) {
		Categorie categorie = null;

		try {
			categorie = dao.selectById(id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(categorie.getLibelle().equals("")) return null;
		return categorie;
	}
	
	public int recupererCategorie(String nom) {
		Categorie categorie = null;

		try {
			categorie = dao.searchName(nom);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(categorie.getLibelle().equals("")) return 0;
		return categorie.getNo_categorie();
	}

}

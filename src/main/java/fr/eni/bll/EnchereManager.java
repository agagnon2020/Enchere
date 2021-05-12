package fr.eni.bll;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.dal.BusinessException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.EnchereDAO;

public class EnchereManager {
	
		private EnchereDAO dao;
		
		public EnchereManager() {
			this.dao = DAOFactory.getEnchereDAO();
		}
		
		
		//Retourner la meilleure enchere d'un produit 
		public Enchere selectBest(int idArticle) {
			Enchere enchereBest = null;
			try {
				return dao.selectBest(idArticle);
			} catch (BusinessException e) {
					e.printStackTrace(); 
			}
			return enchereBest;
		}
		
		
			
		// Enregistrer une nouvelle enchere pour un article
		public Enchere insert(Enchere enchere) {
			try {
				return dao.insert(enchere);
			} catch (BusinessException e) {
					e.printStackTrace(); 
			}
			return null;
		}
		
		// Supprimer un article
		public void deleteEnchere(int id) {

					try {
						dao.deleteEnchere(id);
					} catch (BusinessException e) {
						e.printStackTrace();
					}

			}
		
		// Modifier un article 
		public void updateEnchere(Enchere enchere) {

				try {
					dao.updateEnchere(enchere);
				} catch (BusinessException e) {
							e.printStackTrace();
				}

		}
		

}

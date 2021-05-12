package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Enchere;

public class EnchereManager {
	
		private EnchereManager dao;
		
		public EnchereManager() {
			this.dao = DAOFactory.getEnchereDAO();
		}
		
		// Etape 1 : Faire la liste des ench�res propos�es d'un Article 
		public List<Enchere> ListeDesEncheres() {
			List<Enchere> listeArticles = new ArrayList<Enchere>();
			
			try {
				listEncheres = dao.selectAll();
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
			// Etape2 : retourner l'ench�re la plus �lev�e
			return enchereGagnante;
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
		

}

package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Enchere;
import fr.eni.dal.BusinessException;

public class EnchereManager {
	
		private EnchereManager dao;
		
		public EnchereManager() {
			this.dao = DAOFactory.getEnchereDAO();
		}
		
		// Etape 1 : Faire la liste des enchères proposées d'un Article 
		public List<Enchere> ListeDesEncheres() {
			Enchere enchereGagnante = null;
			List<Enchere> listeEncheres = new ArrayList<Enchere>();
			
			// Faire une liste des encheres par le no_article
			listeEncheres = dao.selectById();
			
			// Etape2 : retourner l'enchère la plus élevée
			for(int i = 0; i < listeEncheres.size(); i++) 
				for (int k = i + 1; k < listeEncheres.size(); k++)
				if (listeEncheres.get(i) > listeEncheres.get(k)){
						System.out.println(enchereGagnante);
					try {
						return enchereGagnante;
					} catch (BusinessException e) {
						e.printStackTrace();
					}
			}
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

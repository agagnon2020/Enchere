package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.BusinessException;
import fr.eni.dal.UserDAOJdbcImpl;


public class UserManager {
	/*
	 * Objectif : Vérifier que l'identifiant et le mdp est connu et valide. Si oui retourner l'utilisateur
	 */
	public Utilisateur authentifier(String pseudoParam, String mdpParam) {
        Utilisateur utilisateur=null;
		
        UserDAOJdbcImpl DAO = new UserDAOJdbcImpl();
        try {
			utilisateur = DAO.selectByAuth(pseudoParam, mdpParam);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if( utilisateur == null ) {
	        try {
				utilisateur = DAO.selectByMail(pseudoParam, mdpParam);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return utilisateur;
	}
	
	
	 // Enregistrer le profil d'un utilisateur
		public Integer inscrire(Utilisateur user){
			
			UserDAOJdbcImpl DAO = new UserDAOJdbcImpl();
			Integer id = null;
			try {
				id = DAO.insert(user);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return id;
			
		}
		
		// Restituer les informations du profil d'utilisateur
		
		public Utilisateur infosProfil(Integer id) {
			
			
			UserDAOJdbcImpl DAO = new UserDAOJdbcImpl();
	        Utilisateur infosUtilisateur = new Utilisateur();
			try {
				infosUtilisateur = DAO.selectById(id);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return infosUtilisateur;
		}
		
		// Enregistrer des modifications apporté au profil par l'utilisateur
		
		public void modifierProfil(Utilisateur user){
			
			UserDAOJdbcImpl DAO = new UserDAOJdbcImpl();
			try {
				DAO.updateUser(user);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public void supprimerProfil(Integer id){
			
			UserDAOJdbcImpl DAO = new UserDAOJdbcImpl();
			try {
				DAO.deleteUser(id);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
}

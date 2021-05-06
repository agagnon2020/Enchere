package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.BusinessException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UserDAO;

public class UserManager {
	private UserDAO dao;

	public UserManager() {
		this.dao = DAOFactory.getUserDAO();
	}

	/*
	 * Objectif : Vérifier que l'identifiant et le mdp est connu et valide. Si oui
	 * retourner l'utilisateur
	 */
	public Utilisateur authentifier(String pseudoParam, String mdpParam) {
		Utilisateur utilisateur = null;

		try {
			utilisateur = dao.selectByAuth(pseudoParam, mdpParam);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;
	}

	// Enregistrer le profil d'un utilisateur
	public Integer inscrire(Utilisateur user) {

		Integer id = null;
		try {
			id = dao.insert(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;

	}

	// Restituer les informations du profil d'utilisateur

	public Utilisateur infosProfil(Integer id) {

		Utilisateur infosUtilisateur = new Utilisateur();
		try {
			infosUtilisateur = dao.selectById(id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infosUtilisateur;
	}

	// Enregistrer des modifications apporté au profil par l'utilisateur

	public void modifierProfil(Utilisateur user) {

		try {
			dao.updateUser(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void supprimerProfil(Integer id) {

		try {
			dao.deleteUser(id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

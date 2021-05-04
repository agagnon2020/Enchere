package fr.eni.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec lors de la lecture des utilisateurs
	 */
	public static final int SELECT_USER_ECHEC=10002;
			
	/**
	 * Echec lors de la suppression des utilisateurs
	 */
	public static final int DELETE_USER_ECHEC=10003;
		
}













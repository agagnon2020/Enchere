package test;

import bll.UserManager;
import bo.Utilisateur;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur user1 = new Utilisateur("JeanChristopheDu06", "Jean", "Christophe", "jean.christophe@gmail.com", 06, "Rue jean", 44000, "Nantes", "mdpmdp", 100, false);
		Utilisateur user2 = new Utilisateur("JeanCharleDu35", "Jean", "Charle", "jean.charle@gmail.com", 06, "Rue jean", 35000, "Rennes", "mdpmdp2", 100, true);
		Utilisateur user3 = new Utilisateur("MarieChristine", "Marie", "Christine", "mpariechristine@gmail.com", 06, "Avenue de la vie", 01010, "La Lune", "mdpmdp3", 100, false);
		UserManager manager = new UserManager();

		manager.inscrire(user1);
		manager.inscrire(user2);
		manager.inscrire(user3);
		System.out.println(manager.infosProfil(user1.getNo_utilisateur()));
		System.out.println(manager.infosProfil(user2.getNo_utilisateur()));
		System.out.println(manager.infosProfil(user3.getNo_utilisateur()));
		manager.supprimerProfil(user3.getNo_utilisateur());
		user1.setPseudo("MichelDu33");
		manager.modifierProfil(user1);
		System.out.println(manager.infosProfil(user1.getNo_utilisateur()));
	}

}

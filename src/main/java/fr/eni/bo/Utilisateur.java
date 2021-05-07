package fr.eni.bo;

public class Utilisateur {
		//déclarations des variables
	private int no_utilisateur, credit;
	private String pseudo, nom, prenom, email, rue, ville, mot_de_passe, telephone, code_postal;
	private Boolean administrateur;
	
	public Utilisateur(String pseudoParam, String  nomParam, String prenomParam, String emailParam, String telParam,
			String rueParam, String cpParam, String villeParam, String mdpParam, int creditParam, Boolean adminParam) {
		this.pseudo = pseudoParam;
		this.nom = nomParam;
		this.prenom = prenomParam;
		this.email = emailParam;
		this.telephone = telParam;
		this.rue = rueParam;
		this.code_postal = cpParam;
		this.ville = villeParam;
		this.mot_de_passe = mdpParam;
		this.credit = creditParam;
		this.administrateur = adminParam;
	}
	
	public Utilisateur(int numUser, String pseudoParam, String  nomParam, String prenomParam, String emailParam, String telParam,
			String rueParam, String cpParam, String villeParam, String mdpParam, int creditParam, Boolean adminParam) {
		this.pseudo = pseudoParam;
		this.nom = nomParam;
		this.prenom = prenomParam;
		this.email = emailParam;
		this.telephone = telParam;
		this.rue = rueParam;
		this.code_postal = cpParam;
		this.ville = villeParam;
		this.mot_de_passe = mdpParam;
		this.credit = creditParam;
		this.administrateur = adminParam;
		this.no_utilisateur = numUser;
	}
	
	public Utilisateur(){
		this.nom = "";
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "User [no_utilisateur=" + no_utilisateur + ", telephone=" + telephone + ", credit=" + credit
				+ ", code_postal=" + code_postal + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", rue=" + rue + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe
				+ ", administrateur=" + administrateur + "]";
	}
	
	
}


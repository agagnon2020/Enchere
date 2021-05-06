package fr.eni.bo;

import java.util.Date;

public class ArticleVendu {
	private int noArticle, miseAPrix, prixVente;
	private String nomArticle, description, etatVente;
	private Date dateDebutEncheres, dateFinEncheres;
	private Utilisateur vendeur;
	private Categorie categorie;

	public ArticleVendu(int miseAPrix, int prixVente, String nomArticle, String description, String etatVente,
			Date dateDebutEncheres, Date dateFinEncheres, Utilisateur vendeur, Categorie categorie) {
		super();
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.nomArticle = nomArticle;
		this.description = description;
		this.etatVente = etatVente;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}

	public ArticleVendu() {
		super();
		
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
}

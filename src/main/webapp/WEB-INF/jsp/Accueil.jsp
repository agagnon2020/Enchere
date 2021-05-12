<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="fr.eni.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.bll.ArticleManager"%>
<%@page import="java.text.SimpleDateFormat"%> 
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
<body>
	<header>
		<%@ include file="../fragments/header.jsp"%>
	</header>
	<div class="deco_popup ${statut}">

		<!-- The Modal -->
		<div id="myModal" class="modal"
			onclick="this.className = 'is-not-visible'">
			<div class="modal-content">
				<span class="close_popup">&times;</span>
				<p>${msgDeconnexion}</p>
				<p>${erreur}</p>
			</div>
		</div>
	</div>
	<h1>Liste des enchères</h1>

	<form class="filtre" action="accueil" method="post">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								<p>Filtres :</p>
							</td>
						</tr>
						<tr>
							<td><input type="text" id="barreRecherche" name="recherche"
								placeholder="Le nom de l'article contient" value="<%
						if (request.getParameter("recherche") != null) {
							pageContext.setAttribute("recherche", request.getParameter("recherche"));
						}
						%>${recherche}"></td>
						</tr>
						<tr>
							<td><label for="categorie">Catégorie : </label> <select
								id="categorie" name="Categories">
									<option value="all">Toutes</option>
									<option value="informatique">Informatique</option>
									<option value="ameublement">Ameublement</option>
									<option value="vetement">Vêtement</option>
									<option value="sport">Sport & Loisirs</option>
							</select></td>
						</tr>
						<%
						if (session.getAttribute("utilisateur") != null) {
						%>
						<tr>
							<td><input type="radio" name="select" value="achats">
								<label for="select">Achats</label> <br /> <input type="checkbox"
								name="option1" value="1"> <label for="option1">Enchères
									ouvertes</label> <br /> <input type="checkbox" name="option2" value="2">
								<label for="option2">Mes enchères</label> <br /> <input
								type="checkbox" name="option3" value="3"> <label
								for="option3">mes enchères remportées</label></td>
							<td><input type="radio" name="select" value="ventes">
								<label for="select">Ventes</label> <br /> <input type="checkbox"
								name="option1" value="1"> <label for="option1">Mes
									ventes en cours</label> <br /> <input type="checkbox" name="option2"
								value="2"> <label for="option2">Ventes non
									débutées</label> <br /> <input type="checkbox" name="option3" value="3">
								<label for="option3">Ventes terminées</label></td>
						</tr>
						<%
						}
						%>
					</table>
				</td>
				<td class="seconde_column"><input type="button" onclick="window.location.href='/Enchere?recherche='+document.getElementById('barreRecherche').value+'&categorie='+document.getElementById('categorie').value" value="Rechercher"></td>
			</tr>
		</table>
		<table cellspacing="15" class="tableArticle">
			<tr>
				<%
				ArticleManager manager = new ArticleManager();
				String barreRecherche = (String) request.getParameter("recherche");
				String categorie = (String) request.getParameter("categorie");
				List<ArticleVendu> listeRecherche = new ArrayList<ArticleVendu>();
				List<ArticleVendu> listeCategorie = new ArrayList<ArticleVendu>();
				List<ArticleVendu> listeFinale = new ArrayList<ArticleVendu>();
				if(categorie == "all") categorie = null;
				if(barreRecherche == "") barreRecherche = null;
				if(barreRecherche != null) {
					listeRecherche = manager.rechercheArticles(barreRecherche);
				} 
				if(categorie != null) {
					listeCategorie = manager.rechercheCategorie(categorie);
				}
				if(listeRecherche.size() <= 0 && listeCategorie.size() <= 0) {
					listeFinale = manager.ListeDesArticles();
				} else {
					if(listeCategorie.size() > 0 && barreRecherche != null) {
					    for(ArticleVendu art : listeCategorie){
						    for(ArticleVendu art2 : listeRecherche) {
						    	if(art.getNoArticle() == art2.getNoArticle()) {
						    		listeFinale.add(art);
						    	}
						    }
					    }
					} else if (listeCategorie.size() > 0) {
						listeFinale = listeCategorie;
					} else {
						listeFinale = listeRecherche;
					}
				}
				Iterator<ArticleVendu> it = listeFinale.iterator();
				int index = 0;
				while (it.hasNext()) {
					index++;
					ArticleVendu article = it.next();
					pageContext.setAttribute("articleNom", article.getNomArticle());
					pageContext.setAttribute("articlePrix", article.getMiseAPrix());
					SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
					String dateEnd = format1.format(article.getDateFinEncheres());
					pageContext.setAttribute("articleFin", dateEnd);
					pageContext.setAttribute("articleVendeur", article.getVendeur().getPseudo());
					pageContext.setAttribute("identifiantArticle", article.getNoArticle());
				%>
				<td><%if(session.getAttribute("utilisateur")!=null){%>
					<a href="/Enchere/ficheArticle?article=${identifiantArticle}">
					<%}else{%>
					<p>Vous devez vous connecter pour voir les details de cet article.</p>
					<%}%>
					<div class="article">
						<h2>${articleNom}</h2> 
						<p>Prix : ${articlePrix} points </p> 
						<p>Fin de l'enchère : ${articleFin}</p>
						<p>Vendeur : ${articleVendeur}</p>
					</div>
					</a>
				</td>
				<%
					if (index == 3) {
						index = 0;
					%>
						</tr>
						<tr>
					<%
					}
				}
				%>
			</tr>
		</table>
	</form>
</body>
</html>
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
	<div
		class="deco_popup ${statut}">

		<!-- The Modal -->
		<div id="myModal" class="modal" onclick="this.className = 'is-not-visible'">
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
							<td><input type="text" name="recherche"
								placeholder="Le nom de l'article contient"></td>
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
						<%if(session.getAttribute("utilisateur")!=null){%>
						<tr>
							<td>
								<input type="radio" name="select" value="achats">
								<label for="select">Achats</label>
							<br/>
								<input type="checkbox" name="option1" value="1" >
								<label for="option1">Enchères ouvertes</label>
							<br/>
								<input type="checkbox" name="option2" value="2">
								<label for="option2">Mes enchères</label>
							<br/>
								<input type="checkbox" name="option3" value="3">
								<label for="option3">mes enchères remportées</label>
							</td>
							<td>
								<input type="radio" name="select" value="ventes">
								<label for="select">Ventes</label>
							<br/>
								<input type="checkbox" name="option1" value="1">
								<label for="option1">Mes ventes en cours</label>
							<br/>
								<input type="checkbox" name="option2" value="2">
								<label for="option2">Ventes non débutées</label>
							<br/>
								<input type="checkbox" name="option3" value="3">
								<label for="option3">Ventes terminées</label>
							</td>
						</tr>
						<%}%>
					</table>
				</td>
				<td class="seconde_column"><input type="submit"
					value="Rechercher"></td>
			</tr>
		</table>
	</form>
</body>
</html>
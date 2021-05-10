
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
<body>
	<header>
		<%@ include file="../fragments/header.jsp"%>
	</header>
	<h1>Nouvelle vente</h1>

	<form action="venteArticle" method="post">
		<table>
			<tr>
				<td>Article :</td>
				<td><input type="text" name="nom_article"></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><textarea name="desc_article"></textarea></td>
			</tr>
			<tr>
				<td><label for="categorie">Catégorie : </label></td>
				<td><select id="categorie" name="Categories">
						<option value="all">Toutes</option>
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">Vêtement</option>
						<option value="sport">Sport & Loisirs</option>
				</select></td>
			</tr>
			<tr>
				<td>Photo de l'article :</td>
				<td><input type="file" name="photo_article" accept="image/png, image/jpeg">
				</td>
			</tr>
			<tr>
				<td>Mise à prix :</td>
				<td><input type="number" name="prix_article">
				</td>
			</tr>
			<tr>
				<td>Début de l'enchère : </td>
				<td><input type="datetime" name="debut_vente">
				</td>
			</tr>
			<tr>
				<td>Fin de l'enchère : </td>
				<td><input type="datetime" name="fin_vente">
				</td>
			</tr>
			</table>
			<table>
			<tr>
				<td>
					<fieldset>
						<legend>Retrait</legend>
						<label for="rue_retrait">Rue :</label>
						<input type="text" name="rue_retrait" placeholder="${utilisateur.rue}">
						<br/>
						<label for="cp_retrait">Code postal :</label>"
						<input type="text" name="cp_retrait" placeholder="${utilisateur.code_postal}">
						<br/>
						<label for="ville_retrait">Ville :</label>"
					<input type="text" name="ville_retrait" placeholder="${utilisateur.ville}">
					</fieldset>
				</td>
			</tr>
			</table>
			<table>
			<tr>
				<td>
					<input type="submit" value="Enregistrer">
				</td>
				<td>
					<button type="button" onclick="window.location.href='accueil'">Annuler</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
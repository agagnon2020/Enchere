
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
<body>
	<header>
		<%@ include file="../fragments/header.jsp"%>
	</header>
	<h1>Fiche de l'article ${articleNom} </h1>

	<form action="vente" method="post">
		<table>
			<tr>
				<td>Article :</td>
				<td>${articleNom}</td>
			</tr>
			<tr>
				<td>Description :</td>
				<td>${articleDescription}</td>
			</tr>
			<tr>
				<td><p>Catégorie : </p></td>
				<td>${articleCategorie}</td>
			</tr>
			<tr>
				<td>Photo de l'article :</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>Mise à prix :</td>
				<td>${articlePrix}
				</td>
			</tr>
			<tr>
				<td>Début de l'enchère : </td>
				<td>${articleDateDebut}
				</td>
			</tr>
			<tr>
				<td>Fin de l'enchère : </td>
				<td>${articleDateFin}
				</td>
			</tr> 
			<tr>
				<td>Vendeur : </td>
				<td>${articleVendeur}
				</td>
			</tr> 
			</table>
			<table>
			<tr>
				<td>
					<fieldset>
						<legend>Retrait</legend>
						<p>Rue :</p>
						${articleRue}
						<br/>
						<p>Code postal :</p>
						${articleCodePostal}
						<br/>
						<p>Ville :</p>
						${articleVille}
					</fieldset>
				</td>
			</tr>
		</table>
	</form>
	<form action="enchere?article=${article}" method="post">
	<table>
			<tr>
				<td>
					<fieldset>
						<legend>Proposition de l'enchère</legend>
						<p>Date de l'enchère</p>
						${dateDuJour}
						<br/>
						<p>Mise à prix de l'enchere :</p>
						<input type="number" name="prix_enchere"></input>
						<br/>
						<input type="submit" value="Enregistrer">
					</fieldset>
				</td>
			</tr>
	</table>	
	</form>
</body>
</html>
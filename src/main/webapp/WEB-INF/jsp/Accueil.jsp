<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Accueil ENI-Enchere</title>
</head>
<body>
	<header>
		<div>
			<a class="logo" href="accueil">ENI - Ench�res</a>
		</div>
		<div>
			<a href="connexion">S'inscrire - Se connecter</a>
		</div>
	</header>
	<h1>Liste des ench�res</h1>

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
							<td><label for="categorie">Cat�gorie : </label> <select
								id="categorie" name="Categories">
									<option value="all">Toutes</option>
									<option value="informatique">Informatique</option>
									<option value="ameublement">Ameublement</option>
									<option value="vetement">V�tement</option>
									<option value="sport">Sport & Loisirs</option>
							</select></td>
						</tr>
					</table>
				</td>
				<td class="seconde_column">
				<input type="submit" value="Rechercher">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
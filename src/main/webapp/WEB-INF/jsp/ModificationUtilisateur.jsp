<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Modifier votre profil</title>
</head>
<jsp:include page="/WEB-INF/fragments/head.jsp"/>
<body>
	<header>
		<%@ include file="../fragments/header.jsp" %>
	</header>
	
	<h1>Mon profil</h1>
	
	<form class="modification" action="modification" method="post">
<table>
		<tr>
			<td>
				Pseudo :
			</td>
			<td>
				<input type="text" name="pseudo" placeholder="${utilisateur.pseudo}">
			</td>
			<td>
				Nom :
			</td>
			<td>
				<input type="text" name="nom" placeholder="${utilisateur.nom}">
			</td>
		</tr>
		<tr>
			<td>
				Prénom :
			</td>
			<td>
				<input type="text" name="prenom" placeholder="${utilisateur.prenom}">
			</td>
			<td>
				Email :
			</td>
			<td>
				<input type="text" name="email" placeholder="${utilisateur.email}">
			</td>
		</tr>
		<tr>
			<td>
				Téléphone :
			</td>
			<td>
				<input type="text" name="telephone" placeholder="${utilisateur.telephone}">
			</td>
			<td>
				Rue :
			</td>
			<td>
				<input type="text" name="rue" placeholder="${utilisateur.rue}">
			</td>
		</tr>
		<tr>
			<td>
				Code postal :
			</td>
			<td>
				<input type="text" name="code_postal" placeholder="${utilisateur.code_postal}">
			</td>
			<td>
				Ville :
			</td>
			<td>
				<input type="text" name="ville" placeholder="${utilisateur.ville}">
			</td>
		</tr>
		<tr>
			<td>
				Mot de passe actuel :
			</td>
			<td>
				<input type="password" name="mot_de_passe" placeholder="${utilisateur.mot_de_passe}">
			</td>
			<td>
			
			</td>
			<td>
			
			</td>
		</tr>
		<tr>
			<td>
				Nouveau mot de passe :
			</td>
			<td>
				<input type="password" name="n_mot_de_passe">
			</td>
			<td>
				Confirmation :
			</td>
			<td>
				<input type="password" name="c_mot_de_passe">
			</td>
		</tr>
		<tr>
			<td>
				Crédits :
			</td>
			<td>
				${utilisateur.credit}
			</td>
			<td>
			
			</td>
			<td>
			
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<input type="submit" value="Enregistrer">
			</td>
			<td>
				<input type="submit" onclick="window.location='/Enchere/SuppressionCompte';" value="Supprimer" name="Supprimer mon compte"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
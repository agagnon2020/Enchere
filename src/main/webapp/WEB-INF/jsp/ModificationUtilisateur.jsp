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
<table>
		<tr>
			<td>
				Pseudo :
			</td>
			<td>
				${utilisateur.pseudo}
			</td>
			<td>
				Nom :
			</td>
			<td>
				${utilisateur.nom}
			</td>
		</tr>
		<tr>
			<td>
				Prénom :
			</td>
			<td>
				${utilisateur.prenom}
			</td>
			<td>
				Email :
			</td>
			<td>
				${utilisateur.email}
			</td>
		</tr>
		<tr>
			<td>
				Téléphone :
			</td>
			<td>
				${utilisateur.telephone}
			</td>
			<td>
				Rue :
			</td>
			<td>
				${utilisateur.rue}
			</td>
		</tr>
		<tr>
			<td>
				Code postal :
			</td>
			<td>
				${utilisateur.code_postal}
			</td>
			<td>
				Ville :
			</td>
			<td>
				${utilisateur.ville}
			</td>
		</tr>
		<tr>
			<td>
				Mot de passe actuel :
			</td>
			<td>
				${utilisateur.mdp}
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
				<input type="submit" value="Supprimer" name="Supprimer mon compte">
			</td>
		</tr>
	</table>
</body>
</html>
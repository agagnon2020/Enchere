<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Compte Utilisateur</title>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
			<td>
				Ville :
			</td>
			<td>
				${utilisateur.ville}
			</td>
		</tr>
		<tr>
			<td>
				<button onclick="window.location.href='ModifierProfil'">Modifier</button>
			</td>
		</tr>
	</table>
</body>
</html>
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
	
<a href="ModifierProfil">Modifier le profil</a>


<h2>Compte Utilisateur: </h2>

<p>Récapitulatif de vos coordonées</p>



	   <fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   <legend>Voici votre profil ${utilisateur.pseudo}</legend>
	   <p>Identifiant :  ${utilisateur.pseudo}
       </p>
       <p>Crédit : ${utilisateur.credit}
       </p>
       <p>Nom : ${utilisateur.nom}
       </p>
       <p>Prenom : ${utilisateur.prenom}
       </p>
       <p>email : ${utilisateur.email}
       </p>
       <p>Numéro de téléphone : ${utilisateur.telephone}
       </p>
       <p>Rue ou Avenue : ${utilisateur.rue}
       </p>
       <p>Code Postal : ${utilisateur.code_postal}
       </p>
       <p>Ville :  ${utilisateur.ville}
       </p>    
       <p>Mot de passe : ${utilisateur.mot_de_passe}
       </p>
       </fieldset>

</body>
</html>
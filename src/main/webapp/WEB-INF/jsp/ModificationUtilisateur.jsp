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

<p>Complétez le champs correspondant à la modification que vous souhaitez apporter</p>
<a style='text-align: left;' href="http://localhost:8080/Encheres/SupprimerProfil" ><button>Supprimer le profil</button> </a><br><br>

	   <form method="post" action="ModifierProfil">
	   
	   <fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   
	   <legend>Modification du profil : ${utilisateur.nom} ${utilisateur.prenom}</legend>
	   
          <p><label for="identifiant">Identifiant à modifier:</label><input type="text" name="pseudo" value="${utilisateur.pseudo}"/></p>
          
          <p><label for="nom">Nom à modifier:</label><input type="text" name="nom" value="${utilisateur.nom}"/></p>
          
          <p><label for="prenom">Prénom à modifier :</label><input type="text" name="prenom" value="${utilisateur.prenom}"/></p>
          
          <p><label for="email">Email à modifier :</label><input type="text" name="email" value="${utilisateur.email}"/></p>
       
          <p><label for="telephone">Telephone à modifier :</label><input type="tel" name="telephone" value="${utilisateur.telephone}"/></p>		
	   
          <p><label for="rue">Rue ou Avenue à modifier :</label><input type="text" name="rue" value="${utilisateur.rue}"/></p> 
       
          <p><label for="code_postal">Code Postal à modifier :</label><input type="text" name="code_postal" value="${utilisateur.code_postal}"/></p>
   
          <p><label for="ville">Ville à modifier :</label><input type="text" name="ville" value="${utilisateur.ville}"/></p>
       
          <p><label for="mot_de_passe">Mot de passe à modifier :</label><input type="text" name="mot_de_passe" value="${utilisateur.mot_de_passe}"/></p>
          
          <br/>
    	  <input type="submit" value="Enregistrer mes modifications"/>
    	  <br><br><input type="reset" value="Annuler"/>
    	  
          </fieldset>
          
       </form>
       
       <br><br>
       
       

</body>
</html>
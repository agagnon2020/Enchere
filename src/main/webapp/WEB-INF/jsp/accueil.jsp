<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Accueil ENI-Enchere</title>
</head>
<body>

<h1> ENI-ENCHERES </h1>

<nav class="onglets">
    <ul>
        <li class="onglet"><button>ACCUEIL</button></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/AnnonceVenteArticle"><button>VENDRE UN ARTICLE</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Profil"><button>VOTRE COMPTE</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Deconnexion"><button>DECONNEXION</button></a></li>
    </ul>
</nav>

<%String message=(String)request.getAttribute("msgJSP"); %>
<div><h2> Bienvenue <%=message %> dans notre salle de vente aux enchères !</h2></div>

<p style='color: green;text-align:center;font-size:20px;'>${enregistrementArticle}</p>

<fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   <legend>Liste d'articles en vente</legend>
	   <p>Article 1
       </p>
       <p>Article 2
       </p>
       <p>Article 3
       </p>
       <p>Article 4
       </p>
       <p>Article 5
       </p>
       <p>Article 6
       </p>
       </fieldset>

</body>
</html>
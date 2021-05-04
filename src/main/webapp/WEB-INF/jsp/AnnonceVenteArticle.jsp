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
        <li class="onglet"><a href="http://localhost:8080/Encheres/Accueil"><button>ACCUEIL</button></a></li>
        <li class="onglet"><button>VENDRE UN ARTICLE</button></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Profil"><button>VOTRE COMPTE</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Deconnexion"><button>DECONNEXION</button></a></li>
    </ul>
</nav>

<div><h2> Cr�er une nouvelle annonce pour vendre votre article !</h2></div>

 <form method="post" action="/Encheres/AnnonceVenteArticle">
 <fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   
	   <legend>Nouvel Article � vendre:</legend>
       
       <p>
          <label for="nomArticle">Nom de l'article :</label><br/>
           <input type="text" name="nomArticle"autofocus required/>
       </p>
       
       <p>
          <label for="description">Description de l'article :</label><br/>
           <input type="text" size="55%" name="description"autofocus required/>
       </p>
       
        <p>
          <label for="categorie">Cat�gorie de l'article :</label><br/>
           <input type="text" name="categorie"autofocus required/>
       </p>
       
       <p>
          <label for="prix">Prix de d�part :</label><br/>
           <input type="number" name="prix"autofocus required/>
       </p>
       
        <p>
          <label for="dateDebut">Date et Heure d�but de l'ench�re :</label><br/>
           <input type="date" name="dateDebut" placeholder="JJ/MM/AAAA" autofocus required/>
            <input type="time" name="heureDebut" placeholder="HH.MM" autofocus required/>
       </p>
       
       <p>
          <label for="dateFin">Date et Heure fin de l'ench�re :</label><br/>
            <input type="date" name="dateFin" placeholder="JJ/MM/AAAA" autofocus required/>
            <input type="time" name="heureFin" placeholder="HH.MM" autofocus required/>
       </p>
       
        <p>
          <label for="modalit�Retrait">Modalit�s du retrait de l'article 
          <br>(Votre adresse servira de point de retrait par d�faut pour votre acheteur sans informations suppl�mentaires de votre part) :</label><br/>
           <input type="text" size="55%" name="modalit�Retrait"  value="${utilisateur.rue}  ${utilisateur.code_postal}  ${utilisateur.ville}"/>
       </p>
    <input type="submit" value="Enregistrer l'article"/><br><br>
    
     <input type="reset" value="Annuler"/>
    </fieldset>
    </form>

</body>
</html>
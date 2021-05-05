<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Créer votre profil</title>
</head>
<body>

<h1> ENI-ENCHERES </h1>

<nav class="onglets">
    <ul>
        <li class="onglet"><a href="http://Localhost:8080/Enchere/accueil"><button>ACCUEIL</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Enchere/connexion"><button>CONNEXION</button></a></li>
    </ul>
</nav>

<h2>Connectez-vous</h2>

<section>
    

    <p style='color: green'>${msgDeconnexion}</p>
    
    <p style='color: red'>${erreur }</p>
    <form method="post" action="/Encheres/UsersConnexion">
       
       <p>
          <label for="identifiant">Identifiant :</label><br/>
           <input id="identifiant" type="text" name="identifiant" autofocus required/>
       </p>
       
       
       <p>
          <label for="password">Mot de passe :</label><br/>
           <input id="password" type="password" name="mot_de_passe" autofocus required/>
       </p>
       
       <br/>
    <br/>
    <input type="submit" value="Connexion"/>
   
       
        
    </form>
    
</section>

<h2>Créer votre compte</h2>

	<section>
    <form method="post" action="/Enchere/inscription">
    <fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   
	   <legend>Formulaire d'inscription :</legend>
       
       <p>
          <label for="identifiant">Identifiant :</label><br/>
           <input type="text" name="identifiant" autofocus required/>
       </p>
       
       <p>
          <label for="nom">Nom :</label><br/>
           <input id="nom" type="text" name="nom" autofocus required/>
       </p>
       
        <p>
          <label for="prenom">Prenom :</label><br/>
           <input type="text" name="prenom" autofocus required/>
       </p>
       
       <p>
          <label for="name">Email :</label><br/>
           <input type="email" name="email" autofocus required/>
       </p>
       
        <p>
          <label for="telephone">Numéro de téléphone :</label><br/>
           <input type="tel" name="telephone" autofocus required/>
       </p>
       
       <p>
          <label for="rue">Rue ou Avenue :</label><br/>
           <input type="text" name="rue" autofocus required/>
       </p>
       
        <p>
          <label for="code_postal">Code Postal :</label><br/>
           <input type="text" name="code_postal" autofocus required/>
       </p>
       
       <p>
          <label for="ville">Ville :</label><br/>
           <input type="text" name="ville" autofocus required/>
       </p>
       
       <p>
          <label for="mot_de_passe">Mot de passe :</label><br/>
           <input id="mot_de_passe" type="password" name="mot_de_passe" autofocus required/>
       </p>
       
       <br/>
    <br/>
    <input type="submit" value="Inscription"/>
     <input type="reset" value="Annuler"/>

</fieldset>
    </form>
	</section>


</body>
</html>
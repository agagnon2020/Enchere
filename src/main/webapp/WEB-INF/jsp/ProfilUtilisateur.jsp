<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Compte Utilisateur</title>
</head>
<body>

<h1> ENI-ENCHERES </h1>

<nav class="onglets">
    <ul>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Accueil"><button>ACCUEIL</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/ModificationUtilisateur"><button>MODIFIER PROFIL</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/SupprimerProfil"><button>SUPRIMMER PROFIL</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/Deconnexion"><button>DECONNEXION</button></a></li>
    </ul>
</nav>


<h2>Compte Utilisateur: </h2>

<p>Récapitulatif de vos coordonées</p>



	   <fieldset style='margin-left: 30%; margin-right: 30%;text-align:left;'>
	   <legend>Voici votre profil ${utilisateur.identifiant}</legend>
	   <p>Identifiant :  ${utilisateur.identifiant}
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
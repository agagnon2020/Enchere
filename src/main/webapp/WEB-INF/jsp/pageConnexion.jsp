<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
    <title>ENI-Encheres</title>
    <link rel="stylesheet" href='css/style.css'>
    
</head>
<body>
  <h1> ENI-ENCHERES </h1>

<nav class="onglets">
    <ul>
        <li class="onglet"><a href="http://localhost:8080/Encheres/AccueilDeconnecter"><button>ACCUEIL</button></a></li>
        <li class="onglet"><a href="http://localhost:8080/Encheres/inscription"><button>INSCRIPTION</button></a></li>
    </ul>
</nav>
    
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
    
    <br><a href="/Encheres/inscription?action=afficherInscription" >Inscription</a>
    
    </section>
    
    

</body>
    
    
</html>
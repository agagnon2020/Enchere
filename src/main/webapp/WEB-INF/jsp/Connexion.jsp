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
	<header>
        <div>
            <p>ENI-Encheres </p>
        </div>
    </header>
    <form class="connexion" action="connexion" method="post">
        <p>
            <label>Identifiant : </label>
            <input type="text" name="id" >
        </p>
        <p>
            <label>Mot de passe :</label>
            <input type="password" name="mdp">
        </p>
        
        <div>
        <p>
            <input type="submit" value="Connexion">
            </p>
            <p>
            <input type="checkbox"><label>Se souvenir de moi</label>
            <br/>
            <a href="">Mot de passe oublié</a>
            </p>
        </div>
    </form>
	<div class="creacompte">
    <button type="button" onclick="window.location.href='inscription'">Crée un compte</button>
	</div> 
</body>
</html>
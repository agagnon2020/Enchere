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
			<a class="logo" href="accueil">ENI - Enchères</a>
		</div>
	</header>
    <form class="connexion" action="connexion" method="post">
        <table>
            <tr>
                <td>
                    <label>Identifiant : </label>
                </td>
                <td>
                    <input type="text" name="id" >
                </td>
            </tr>
            <tr>
            	<td>
                    <label>Mot de passe :</label>
                </td>
                <td>
                    <input type="password" name="mdp">
                </td>
            </tr>
            <tr class="option_co">
                <td class="button_co">
                    <input type="submit" value="Connexion">
                </td>
                <td class="seconde_column">
                    <input type="checkbox"><label>Se souvenir de moi</label>
                    <br/>
                    <a href="">Mot de passe oublié</a>
                </td>
            </tr>
        </table>
    </form>	
	<div class="creacompte">
    <button type="button" onclick="window.location.href='inscription'">Crée un compte</button>
	</div> 
</body>
</html>
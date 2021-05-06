<%--
  Created by IntelliJ IDEA.
  User: Amandine
  Date: 06/05/2021
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Inscription</title>
</head>
<body>
    <header>
        <div>
            <p>ENI-Encheres </p>
        </div>
    </header>
    <h1>Mon profil</h1>
    <form class="inscription" action="inscription" method="post">
        <table>
            <tr>
                <td>
                    <label>Pseudo : </label>
                </td>
                <td>
                    <input type="text" name="pseudo">
                </td>
                <td class="seconde_column">
                    <label>Nom : </label>
                </td>
                <td>
                    <input type="text" name="nom">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Prénom : </label>
                </td>
                <td>
                    <input type="text" name="prenom">
                </td>
                <td class="seconde_column">
                    <label>Email : </label>
                </td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Téléphone : </label>
                </td>
                <td>
                    <input type="text" name="telephone">
                </td>
                <td class="seconde_column">
                    <label>Rue : </label>
                </td>
                <td>
                    <input type="text" name="rue">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Code postal : </label>
                </td>
                <td>
                    <input type="text" name="cp">
                </td>
                <td class="seconde_column">
                    <label>Ville : </label>
                </td>
                <td>
                    <input type="text" name="ville">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Mot de passe : </label>
                </td>
                <td>
                    <input type="password" name="mdp">
                </td>
                <td class="seconde_column">
                    <label>Confirmation : </label>
                </td>
                <td>
                    <input type="password" name="c_mdp">
                </td>
            </tr>
        </table>
        <table>
        	<tr>
        		<td>
        			<input type="submit" value="Créer">
        		</td>
        		<td class="seconde_column">
        			<button onclick="window.location.href='/accueil'">Annuler</button>
        		</td>
        	</tr>
        </table>
    </form>
</body>
</html>

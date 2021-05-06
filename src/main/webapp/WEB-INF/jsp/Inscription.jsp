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
        <section class="row">
        <div>
            <p>
                <label>Pseudo : </label>
                <input type="text" name="pseudo">
            </p>
            <p>
                <label>Prénom : </label>
                <input type="text" name="prenom">
            </p>
            <p>
                <label>Téléphone : </label>
                <input type="text" name="telephone">
            </p>
            <p>
                <label>Code postal : </label>
                <input type="text" name="cp">
            </p>
            <p>
                <label>Mot de passe : </label>
                <input type="password" name="mdp">
            </p>
        </div>
        <div>
            <p>
                <label>Nom : </label>
                <input type="text" name="nom">
            </p>
            <p>
                <label>Email : </label>
                <input type="text" name="email">
            </p>
            <p>
                <label>Rue : </label>
                <input type="text" name="rue">
            </p>
            <p>
                <label>Ville : </label>
                <input type="text" name="ville">
            </p>
            <p>
                <label>Confirmation : </label>
                <input type="password" name="c_mdp">
            </p>
        </div>
        </section>
        <div>
            <input type="submit" value="Créer">
        </div>
        <div>
            <button onclick="window.location.href='inscription'">Annuler</button>
        </div>
    </form>
</body>
</html>

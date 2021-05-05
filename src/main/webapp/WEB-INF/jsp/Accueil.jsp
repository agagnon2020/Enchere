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
    <header>
        <div>
            <p>ENI-Encheres </p>
        </div>
        <div>
            <a href="Enchere/connexion">S'inscrire - Se connecter</a>
        </div>
    </header>
    <h1>Liste des enchères</h1>
    <section>
        <form class="filtre" action="Enchere/accueil" method="post">
        <div class="column">
            <div>
                <p>Filtres :</p>
            <input type="text" name="recherche" placeholder="Le nom de l'article contient">
            </div>
            <div>
                <label for="categorie">Catégorie : </label>
            <select id="categorie" name="Categories">
            	<option value="all">Toutes</option>
                <option value="informatique">Informatique</option>
                <option value="ameublement">Ameublement</option>
                <option value="vetement">Vêtement</option>
                <option value="sport">Sport & Loisirs</option>
            </select>
            </div>
        </div>
        <div class="column">
            <input type="submit" value="Rechercher">
        </div>
    </form>
    </section>
</body>
</html>
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
            <a href="/UsersConnexion">S'inscrire - Se connecter</a>
        </div>
    </header>
    <h1>Liste des enchères</h1>
    <section>
        <form action="/Accueil" method="post">
            <div>
                <p>Filtres : </p>
                <input type="text" name="recherche" placeholder="Le nom de l'article contient">
                <label for="categorie">Catégorie</label>
                <select id="categorie" name="Toutes">
                    <option value="informatique">Informatique</option>
                    <option value="ameublement">Ameublement</option>
                    <option value="vetement">Vêtement</option>
                    <option value="sport">Sport et Loisirs</option>
                </select>
            </div>
            <div>
                <input type="submit" value="Rechercher">
            </div>
        </form>
    </section>
</body>
</html>
<table class="header_table">
	<tr>
		<td>
			<a class="logo" href="accueil">ENI - Enchères</a>
		</td>
		<td>
			<%if(
        session.getAttribute("utilisateur")!=null){
        %>
        <ul>
            <li>
                <a href="accueil">Enchères</a>
            </li>
            <li>
                <a href="vente">Vendre un article</a>
            </li>
            <li>
                <a href="profil">Mon profil</a>
            </li>
            <li>
                <a href="deconnexion">Déconnexion</a>
            </li>
        </ul>
        <%
        }else{
        %>
        <a href="connexion">S'inscrire - Se connecter</a>
        <%}%>
		</td>
	</tr>
</table>
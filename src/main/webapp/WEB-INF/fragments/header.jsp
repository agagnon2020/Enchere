<table class="header_table">
	<tr>
		<td>
			<a class="logo" href="accueil">ENI - Ench�res</a>
		</td>
		<td>
			<%if(
        session.getAttribute("utilisateur")!=null){
        %>
        <ul>
            <li>
                Encheres
            </li>
            <li>
                Vendre un article
            </li>
            <li>
                Mon profil
            </li>
            <li>
                D�connexion
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
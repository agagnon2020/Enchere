<%@ page language="java" contentType="text/html; charset=ISO-8859-1; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"/>
<body>
	<header>
		<%@ include file="../fragments/header.jsp" %>
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
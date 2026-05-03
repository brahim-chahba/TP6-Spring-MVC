<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestion des Produits</title>
</head>
<body>

    <h1>Gestion des produits | Spring MVC</h1>

    <!-- Formulaire de recherche produit -->
    recherche :
    <form action="${pageContext.request.contextPath}/searchProduct" method="post">
        ID : <input type="text" name="idProduit" value="${idProduit}" />
        <input type="submit" value="Afficher" />
    </form>
    <hr />

    <!-- Formulaire Ajouter / Modifier -->
    <form action="${pageContext.request.contextPath}/${produitEdit != null ? 'updateProduit' : 'addProduct'}" method="post">
        <input type="hidden" name="idProduit"
            value="${produitEdit != null ? produitEdit.idProduit : ''}" />
        Nom :
        <input type="text" name="nom"
            value="${produitEdit != null ? produitEdit.nom : ''}" />
        Description :
        <input type="text" name="description"
            value="${produitEdit != null ? produitEdit.description : ''}" />
        Prix :
        <input type="text" name="prix"
            value="${produitEdit != null ? produitEdit.prix : ''}" />
        <input type="submit"
            value="${produitEdit != null ? 'Mettre a jour' : 'Ajouter'}" />
    </form>
    <hr />
    <br />

    <!-- Tableau affichage des produits -->
    <table border="1" width="50%">
        <tr>
            <th>ID</th>
            <th>NOM</th>
            <th>DESCRIPTION</th>
            <th>PRIX</th>
            <th>Option</th>
        </tr>
        <c:forEach items="${listeProduit}" var="o">
            <tr>
                <td>${o.idProduit}</td>
                <td>${o.nom}</td>
                <td>${o.description}</td>
                <td>${o.prix}</td>
                <td><a href="${pageContext.request.contextPath}/deleteProduit?id=${o.idProduit}">supprimer</a></td>
                <td><a href="${pageContext.request.contextPath}/editProduit?id=${o.idProduit}">Modifier</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

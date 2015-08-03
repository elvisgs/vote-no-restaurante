<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Vote no Restaurante</title>
</head>
<body>
<form method="post" action="${linkTo[HomeController].votar}">
    <label>
        <input type="radio" name="vencedor.id" value="${duelo.restaurante1.id}"/>
        <img src="<c:url value='${duelo.restaurante1.imagem}'/>" alt="${duelo.restaurante1.nome}"/>
    </label>
    <label>
        <input type="radio" name="vencedor.id" value="${duelo.restaurante2.id}"/>
        <img src="<c:url value='${duelo.restaurante2.imagem}'/>" alt="${duelo.restaurante2.nome}"/>
    </label>
    <br/>
    <button type="submit">Próximo &gt;</button>
</form>
</body>
</html>

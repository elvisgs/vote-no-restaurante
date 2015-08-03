<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Vote no Restaurante</title>
</head>
<body>
<form method="post" action="${linkTo[HomeController].finalizarVotacao}">
    <label for="nome">Nome</label>
    <input id="nome" name="votante.nome"/>
    <label for="email">Email</label>
    <input id="email" type="email" name="votante.email"/>
    <br/>
    <button type="submit">Continuar</button>
</form>
</body>
</html>

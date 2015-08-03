<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Ranking</title>
</head>
<body>
<h3>Sua votação</h3>
<ul>
<c:forEach items="${ultimosVotos}" var="v">
    <li>${v.duelo.restaurante1} X ${v.duelo.restaurante2} = ${v.vencedor}</li>
</c:forEach>
</ul>

<h3>Ranking Geral</h3>
<ul>
<c:forEach items="${rankingGeral.itens}" var="r">
    <li>${r.duelo.restaurante1}: ${r.pontosRestaurante1} X ${r.pontosRestaurante2} :${r.duelo.restaurante2}</li>
</c:forEach>
</ul>
</body>
</html>

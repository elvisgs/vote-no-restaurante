<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Ranking</title>
</head>
<body>
<h3>Ranking de ${votante.nome}</h3>
<ul>
<c:forEach items="${votos}" var="v">
    <li>${v.duelo.restaurante1} X ${v.duelo.restaurante2} = ${v.vencedor}</li>
</c:forEach>
</ul>
</body>
</html>

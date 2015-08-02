<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt">
<body>
    <ul>
    <c:forEach items="${duelos}" var="d">
        <li>
            <img src="<c:url value='${d.restaurante1.imagem}'/>" alt="${d.restaurante1.nome}"/> X
            <img src="<c:url value='${d.restaurante2.imagem}'/>" alt="${d.restaurante2.nome}"/>
        </li>
    </c:forEach>
    </ul>
</body>
</html>

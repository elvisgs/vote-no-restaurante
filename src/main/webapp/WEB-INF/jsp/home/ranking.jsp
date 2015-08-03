<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../header.jsp" %>

<div class="container ranking">
    <c:if test="${not empty ultimosVotos}">
        <div class="row well">
            <h3>Sua votação</h3>
            <ul class="list-inline">
            <c:forEach items="${ultimosVotos}" var="v" >
                <li class="col-md-6">
                    <img src="<c:url value='${v.duelo.restaurante1.imagem}'/>" alt="${v.duelo.restaurante1}"
                         title="${v.duelo.restaurante1}"
                         class="img-rounded ${v.vencedor == v.duelo.restaurante1 ? 'vencedor' : ''}"/>
                    <span class="glyphicon glyphicon-remove"></span>
                    <img src="<c:url value='${v.duelo.restaurante2.imagem}'/>" alt="${v.duelo.restaurante2}"
                         title="${v.duelo.restaurante2}"
                         class="img-rounded ${v.vencedor == v.duelo.restaurante2 ? 'vencedor' : ''}"/>
                </li>
            </c:forEach>
            </ul>
        </div>
    </c:if>


    <div class="row well geral">
        <h3>Ranking Geral</h3>
        <ul class="list-inline">
        <c:forEach items="${rankingGeral.itens}" var="r">
            <li class="col-md-6">
                <img src="<c:url value='${r.duelo.restaurante1.imagem}'/>" alt="${r.duelo.restaurante1}"
                     title="${r.duelo.restaurante1}" class="img-rounded"/>
                <span>${r.pontosRestaurante1}</span>
                <span class="glyphicon glyphicon-remove"></span>
                <span>${r.pontosRestaurante2}</span>
                <img src="<c:url value='${r.duelo.restaurante2.imagem}'/>" alt="${r.duelo.restaurante2}"
                     title="${r.duelo.restaurante2}" class="img-rounded"/>
            </li>
        </c:forEach>
        </ul>
    </div>
</div>

<%@ include file="../footer.jsp" %>

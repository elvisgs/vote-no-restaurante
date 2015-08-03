<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../header.jsp" %>

<div class="container">
    <div class="row duelo">
        <h3>Escolha um restaurante</h3>
        <form method="post" action="${linkTo[HomeController].votar}">
            <div class="col-md-5">
                <label>
                    <input type="radio" name="vencedor.id" value="${duelo.restaurante1.id}"/>
                    <img src="<c:url value='${duelo.restaurante1.imagem}'/>" alt="${duelo.restaurante1.nome}"
                         class="img-responsive img-rounded"/>
                    <span class="selecionado glyphicon glyphicon-thumbs-up"/>
                </label>
            </div>
            <div class="col-md-2 versus">
                <span class="glyphicon glyphicon-remove"/>
            </div>
            <div class="col-md-5">
                <label>
                    <input type="radio" name="vencedor.id" value="${duelo.restaurante2.id}"/>
                    <img src="<c:url value='${duelo.restaurante2.imagem}'/>" alt="${duelo.restaurante2.nome}"
                         class="img-responsive img-rounded"/>
                    <span class="selecionado glyphicon glyphicon-thumbs-up"/>
                </label>
            </div>
            <div class="col-md-2 col-md-offset-5" style="text-align:center">
                <button type="submit" class="btn btn-default btn-lg">Votar</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="../footer.jsp" %>
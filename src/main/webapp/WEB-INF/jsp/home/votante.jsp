<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <p>Obrigado por votar! Antes de computar seus votos, por favor informe seus dados.</p>

            <form method="post" action="${linkTo[HomeController].finalizarVotacao}">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input id="nome" name="votante.nome" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" type="email" name="votante.email" class="form-control"/>
                </div>

                <button type="submit" class="btn btn-default pull-right">Continuar</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
package br.com.votenorestaurante.controller;

import br.com.caelum.vraptor.*;
import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.util.Votacao;

import javax.inject.Inject;
import java.util.Optional;

@Controller
public class HomeController {

    private final Votacao votacao;
    private final Result result;

    public HomeController() {
        this(null, null);
    }

    @Inject
    public HomeController(Votacao votacao, Result result) {
        this.votacao = votacao;
        this.result = result;
    }

    @Get("/")
    public void votar() {
        Optional<Duelo> duelo = votacao.proximoDuelo();

        if (duelo.isPresent()) {
            result.include("duelo", duelo.get());
        } else {
            result.forwardTo("/WEB-INF/jsp/home/votante.jsp");
        }
    }

    @Post("/")
    public void votar(Restaurante vencedor) {
        votacao.votar(vencedor);

        result.redirectTo(this).votar();
    }

    @Post
    public void finalizarVotacao(Votante votante) {
        votacao.getVotante().setNome(votante.getNome());
        votacao.getVotante().setEmail(votante.getEmail());
        votacao.finalizar();

        result.redirectTo(this).ranking();
    }

    @Path("/ranking")
    public void ranking() {
        result.include("votos", votacao.getVotante().getVotos());
        result.include("votante", votacao.getVotante());
        votacao.reiniciar();
    }
}

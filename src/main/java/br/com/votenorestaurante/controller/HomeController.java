package br.com.votenorestaurante.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.RestauranteDao;

import javax.inject.Inject;

@Controller
public class HomeController {

    @Inject
    private RestauranteDao restauranteDao;

    @Inject
    private Result result;

    @Get("/")
    public void index() {
        result.include("duelos", restauranteDao.duelosPossiveis());
    }
}

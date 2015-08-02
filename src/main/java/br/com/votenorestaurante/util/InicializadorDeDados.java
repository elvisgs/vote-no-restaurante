package br.com.votenorestaurante.util;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.votenorestaurante.model.Restaurante;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Dependent
public class InicializadorDeDados {

    private final EntityManagerFactory entityManagerFactory;

    @Inject
    public InicializadorDeDados(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void criarRestaurantes(@Observes VRaptorInitialized event) {
        EntityManager em = null;

        try {
            em = entityManagerFactory.createEntityManager();

            em.getTransaction().begin();
            em.persist(new Restaurante("Burger King", "/img/restaurantes/bk.png"));
            em.persist(new Restaurante("Habib's", "/img/restaurantes/habibs.png"));
            em.persist(new Restaurante("Giraffas", "/img/restaurantes/giraffas.png"));
            em.persist(new Restaurante("McDonalds", "/img/restaurantes/mc.png"));
            em.persist(new Restaurante("Subway", "/img/restaurantes/subway.png"));
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }
}

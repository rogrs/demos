package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Evento;

public class EventoServiceImpl extends GenericDAOJPA<Evento, Long> implements GenericJPAService<Evento> {

    public List<Evento> findByName(String name) {
        return super.entityManager.createQuery("SELECT e FROM Evento e WHERE e.sistema = :sistema",Evento.class).setParameter("sistema", name)
                .getResultList();
    }
    
    
   
}

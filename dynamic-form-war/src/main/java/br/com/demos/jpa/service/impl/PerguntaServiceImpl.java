package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Pergunta;

public class PerguntaServiceImpl extends GenericDAOJPA<Pergunta, Long> implements GenericJPAService<Pergunta> {

    public List<Pergunta> findByName(String name) {
        return super.entityManager.createQuery("SELECT p FROM Pergunta p WHERE p.pergunta = :pergunta",Pergunta.class).setParameter("pergunta", name)
                .getResultList();
    }

}

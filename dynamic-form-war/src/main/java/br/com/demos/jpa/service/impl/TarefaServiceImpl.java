package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Tarefa;

public class TarefaServiceImpl extends GenericDAOJPA<Tarefa, Long> implements GenericJPAService<Tarefa> {

    public List<Tarefa> findByName(String name) {
        return super.entityManager.createQuery("SELECT t FROM Tarefa t WHERE t.nmtarefa = :nmtarefa",Tarefa.class).setParameter("nmtarefa", name)
                .getResultList();
    }

}

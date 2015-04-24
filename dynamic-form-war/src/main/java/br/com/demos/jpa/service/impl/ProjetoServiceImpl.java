package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Projeto;

public class ProjetoServiceImpl extends GenericDAOJPA<Projeto, Long> implements GenericJPAService<Projeto> {

    public List<Projeto> findByName(String name) {
        return super.entityManager.createQuery("SELECT p FROM Projeto p WHERE p.nmprojeto = :nmprojeto",Projeto.class).setParameter("nmprojeto", name)
                .getResultList();
    }

}

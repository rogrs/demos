package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Propriedades;

public class PropriedadeServiceImpl extends GenericDAOJPA<Propriedades, Long> implements GenericJPAService<Propriedades> {
    

    public List<Propriedades> findByName(String name) {
       
        return super.entityManager.createQuery("SELECT p FROM Propriedades p WHERE p.chave = :chave and p.enabled =1",Propriedades.class).setParameter("chave", name)
                .getResultList();
    }
    
    public Propriedades findKey(String chave) { 
        return super.entityManager.createQuery("SELECT p FROM Propriedades p WHERE p.chave = :chave and p.enabled =1",Propriedades.class).setParameter("chave", chave).getSingleResult();
    }

}

package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.CasoTeste;

public class CasoTesteServiceImpl extends GenericDAOJPA<CasoTeste, Long> implements GenericJPAService<CasoTeste> {

    public List<CasoTeste> findByName(String name) {
        return super.entityManager.createQuery("SELECT c FROM CasoTeste c WHERE c.nmcasoteste = :nmcasoteste",CasoTeste.class).setParameter("nmcasoteste", name)
                .getResultList();
    }

}

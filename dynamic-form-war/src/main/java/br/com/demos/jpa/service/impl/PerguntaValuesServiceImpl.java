package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Pergunta;
import br.com.demos.vo.PerguntaValues;

public class PerguntaValuesServiceImpl extends GenericDAOJPA<PerguntaValues, Long> implements GenericJPAService<PerguntaValues> {

    public List<PerguntaValues> findByName(String name) {
        return super.entityManager.createQuery("SELECT p FROM Pergunta p WHERE p.pergunta = :pergunta",PerguntaValues.class).setParameter("pergunta", name)
                .getResultList();
    }
    
    public List<PerguntaValues> findPergunta(Pergunta  obj) {
        
        String sql = "SELECT p FROM PerguntaValues p WHERE p.idpergunta = :idpergunta";
        
        return super.entityManager.createQuery(sql,PerguntaValues.class).setParameter("idpergunta", obj.getId())
                .getResultList();
    }

}

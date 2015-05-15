package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Pergunta;

public class PerguntaServiceImpl extends GenericDAOJPA<Pergunta, Long> implements GenericJPAService<Pergunta> {

    public List<Pergunta> findByName(String name) {
        
        String sql = "SELECT p FROM Pergunta p WHERE p.pergunta = :pergunta";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pergunta", name);
        return findQuery(sql, params);
        
    }

}

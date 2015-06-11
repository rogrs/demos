package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Perguntas;

public class PerguntaServiceImpl extends GenericDAOJPA<Perguntas, Long> implements GenericJPAService<Perguntas> {

    public List<Perguntas> findByName(String name) {
        
        String sql = "SELECT p FROM Pergunta p WHERE p.pergunta = :pergunta";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pergunta", name);
        return findQuery(sql, params);
        
    }

}

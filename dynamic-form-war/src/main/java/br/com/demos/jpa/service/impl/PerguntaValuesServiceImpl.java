package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Pergunta;
import br.com.demos.vo.PerguntaValues;

public class PerguntaValuesServiceImpl extends GenericDAOJPA<PerguntaValues, Long> implements GenericJPAService<PerguntaValues> {

    public List<PerguntaValues> findByName(String name) {

        String sql = "SELECT p FROM Pergunta p WHERE p.pergunta = :pergunta";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pergunta", name);
        return findQuery(sql, params);

    }

    public List<PerguntaValues> findPergunta(Pergunta obj) {

        String sql = "SELECT p FROM PerguntaValues p WHERE p.idpergunta = :idpergunta";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idpergunta", obj.getId());
        return findQuery(sql, params);

    }

}

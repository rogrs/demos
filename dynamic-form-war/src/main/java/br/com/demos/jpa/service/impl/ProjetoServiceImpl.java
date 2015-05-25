package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Projeto;

public class ProjetoServiceImpl extends GenericDAOJPA<Projeto, Long> implements GenericJPAService<Projeto> {

    public List<Projeto> findByName(String name) {
        String sql = "SELECT p FROM Projeto p WHERE p.nmprojeto = :nmprojeto";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nmprojeto", name);
        return findQuery(sql, params);

    }

}

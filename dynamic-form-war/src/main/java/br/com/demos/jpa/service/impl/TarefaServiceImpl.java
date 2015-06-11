package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Tarefas;

public class TarefaServiceImpl extends GenericDAOJPA<Tarefas, Long> implements GenericJPAService<Tarefas> {

    public List<Tarefas> findByName(String name) {
        
        String sql = "SELECT t FROM Tarefa t WHERE t.nmtarefa = :nmtarefa";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nmtarefa", name);
        return findQuery(sql, params);
       
    }
    

}

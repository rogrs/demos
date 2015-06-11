package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Eventos;

public class EventoServiceImpl extends GenericDAOJPA<Eventos, Long> implements GenericJPAService<Eventos> {

    public List<Eventos> findByName(String name) {

        String sql = "SELECT e FROM Evento e WHERE e.sistema = :sistema";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sistema", name);
        return findQuery(sql, params);

    }

}

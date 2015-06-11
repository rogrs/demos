package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.CasoTestes;

public class CasoTesteServiceImpl extends GenericDAOJPA<CasoTestes, Long> implements GenericJPAService<CasoTestes> {

    public List<CasoTestes> findByName(String name) {

        String sql = "SELECT c FROM CasoTeste c WHERE c.nmcasoteste = :nmcasoteste";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nmcasoteste", name);
        return findQuery(sql, params);

    }

}

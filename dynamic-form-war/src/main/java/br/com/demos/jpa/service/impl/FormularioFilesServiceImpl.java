package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.FormularioFiles;

public class FormularioFilesServiceImpl extends GenericDAOJPA<FormularioFiles, Long> implements GenericJPAService<FormularioFiles> {

    public List<FormularioFiles> findByName(String name) {

        String sql = "SELECT f FROM FormularioFiles f WHERE f.filepath = :filepath";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("filepath", name);
        return findQuery(sql, params);

    }

    public List<FormularioFiles> findFilesByFormulario(Long idformulario) {

        String sql = "SELECT f FROM FormularioFiles f WHERE f.idformulario = :idformulario";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idformulario", idformulario);
        return findQuery(sql, params);

    }

}

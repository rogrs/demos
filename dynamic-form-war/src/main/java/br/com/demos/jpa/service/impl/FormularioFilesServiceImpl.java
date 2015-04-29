package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.FormularioFiles;

public class FormularioFilesServiceImpl extends GenericDAOJPA<FormularioFiles, Long> implements GenericJPAService<FormularioFiles> {

    public List<FormularioFiles> findByName(String name) {
        
        String sql = "SELECT f FROM FormularioFiles f WHERE f.filepath = :filepath";
        return super.entityManager.createQuery(sql,FormularioFiles.class).setParameter("filepath", name)
                .getResultList();
    }
    
    public List<FormularioFiles> findFilesByFormulario(Long idformulario) {
        
        
        String sql = "SELECT f FROM FormularioFiles f WHERE f.idformulario = :idformulario" ;
        return super.entityManager.createQuery(sql,FormularioFiles.class).setParameter("idformulario", idformulario)
                .getResultList();
    }

}

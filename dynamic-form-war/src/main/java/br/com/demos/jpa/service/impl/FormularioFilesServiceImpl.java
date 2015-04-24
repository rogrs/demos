package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.FormularioFiles;

public class FormularioFilesServiceImpl extends GenericDAOJPA<FormularioFiles, Long> implements GenericJPAService<FormularioFiles> {

    public List<FormularioFiles> findByName(String name) {
        return super.entityManager.createQuery("SELECT p FROM Formulario_Files p WHERE p.filepath = :filepath",FormularioFiles.class).setParameter("filepath", name)
                .getResultList();
    }
    
    public List<FormularioFiles> findFilesByFormulario(Long idformulario) {
        return super.entityManager.createQuery("SELECT p FROM Formulario_Files p WHERE p.idformulario = :idformulario",FormularioFiles.class).setParameter("idformulario", idformulario)
                .getResultList();
    }

}

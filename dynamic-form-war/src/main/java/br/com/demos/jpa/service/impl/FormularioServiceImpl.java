package br.com.demos.jpa.service.impl;

import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.vo.Formulario;

public class FormularioServiceImpl extends GenericDAOJPA<Formulario, Long> implements GenericJPAService<Formulario> {

    @Override
    public List<Formulario> findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    

  

}

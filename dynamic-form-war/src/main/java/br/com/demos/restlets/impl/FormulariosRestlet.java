package br.com.demos.restlets.impl;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.FormularioServiceImpl;
import br.com.demos.restlets.FormularioRest;
import br.com.demos.restlets.forms.FormularioForm;
import br.com.demos.vo.Formulario;

public class FormulariosRestlet implements FormularioRest {

    private static final Logger logger = Logger.getLogger(FormulariosRestlet.class);
    
    private FormularioServiceImpl service = null;
    
    public FormulariosRestlet(){
        
        service = new FormularioServiceImpl();
    }

    
    public Response listAll() {

        

        List<Formulario> entity = null;

        try {
       

            entity = service.findAll();
        } catch (Exception e) {
            logger.error("Erro ao listar formulario", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(FormularioForm form) {
      
        Formulario entity = null;

        URI location = null;

        try {
           

            entity = new Formulario();
            entity.setNome(form.getNome());
            entity.setEstuda(form.getEstuda());
            entity.setCumprimenta(form.getCumprimenta());
            entity.setTorcida(form.getTorcida());
            entity.setModelo(form.getModelo());
            entity.setDtcreate(new Date());
            service.persist(entity);

            // result = "sucesso";
            location = new URI("../index.html");
        } catch (Exception e) {
            logger.error("Erro ao criar formulario", e);

        } finally {

        }
        return Response.temporaryRedirect(location).build();
        // return Response.ok(result).build();

    }

    @Override
    public Response getByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response remove(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

 
}

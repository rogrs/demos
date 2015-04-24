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

    
    public Response listAll() {

        FormularioServiceImpl impl = null;

        List<Formulario> entity = null;

        try {
            impl = new FormularioServiceImpl();

            entity = impl.findAll();
        } catch (Exception e) {
            logger.error("Erro ao listar formulario", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(FormularioForm form) {

        // String result = null;
        FormularioServiceImpl impl = null;
        Formulario entity = null;

        URI location = null;

        try {
            impl = new FormularioServiceImpl();

            entity = new Formulario();
            entity.setNome(form.getNome());
            entity.setEstuda(form.getEstuda());
            entity.setCumprimenta(form.getCumprimenta());
            entity.setTorcida(form.getTorcida());
            entity.setModelo(form.getModelo());
            entity.setDtcreate(new Date());
            impl.persist(entity);

            // result = "sucesso";
            location = new URI("../Home.html");
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
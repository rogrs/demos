package br.com.demos.restlets.impl;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.Form;

import br.com.demos.jpa.service.impl.PerguntaServiceImpl;
import br.com.demos.restlets.PerguntaRest;
import br.com.demos.restlets.forms.PerguntaForm;
import br.com.demos.vo.Pergunta;

public class PerguntasRestlet implements PerguntaRest {

    private static final Logger logger = Logger.getLogger(PerguntasRestlet.class);

    public Response listAll() {

        PerguntaServiceImpl impl = null;

        List<Pergunta> entity = null;

        try {
            impl = new PerguntaServiceImpl();

            entity = impl.findAll();
        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form PerguntaForm form) {

       // String result = null;
        PerguntaServiceImpl impl = null;
        Pergunta entity = null;
        
        URI location = null;

        try {
            impl = new PerguntaServiceImpl();

            entity = new Pergunta();
            entity.setPergunta(form.getPergunta());
            entity.setComponente(form.getComponente());
            entity.setSequencia(form.getSequencia());
            impl.persist(entity);

            // result = "sucesso";
            location = new URI("../Perguntas.html");
        } catch (Exception e) {
            logger.error("erro", e);
   
        } finally {
           
        }
        return Response.temporaryRedirect(location).build();
        //return Response.ok(result).build();

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
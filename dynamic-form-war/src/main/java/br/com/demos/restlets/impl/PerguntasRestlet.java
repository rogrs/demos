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
import br.com.demos.vo.Perguntas;


public class PerguntasRestlet implements PerguntaRest {

    private static final Logger logger = Logger.getLogger(PerguntasRestlet.class);

    private PerguntaServiceImpl service = null;

    public PerguntasRestlet() {

        service = new PerguntaServiceImpl();
    }

    public Response listAll() {

        List<Perguntas> entity = null;

        try {

            entity = service.findAll();
        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form PerguntaForm form) {

        Perguntas entity = null;
        URI location = null;

        try {

            entity = new Perguntas();
            entity.setPergunta(form.getPergunta());
            entity.setComponente(form.getComponente());
            entity.setSequencia(form.getSequencia());
            service.persist(entity);

            location = new URI("../index.html");
        } catch (Exception e) {
            logger.error("erro", e);

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
        Perguntas entity = null;
        URI location = null;
        String uri = null;
        try {
            entity = new Perguntas(id);

            service.remove(entity);
            location = new URI("../index.html");

        } catch (Exception e) {
            logger.error("Erro ao executar remove", e);

        } finally {

        }
        return Response.temporaryRedirect(location).build();
    }

}

package br.com.demos.restlets.impl;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.ProjetoServiceImpl;
import br.com.demos.restlets.ProjetoRest;
import br.com.demos.vo.Projeto;

public class ProjetosRestlet implements ProjetoRest {

    private static final Logger logger = Logger.getLogger(ProjetosRestlet.class);

    private  ProjetoServiceImpl service = null;

    public ProjetosRestlet() {

        service = new ProjetoServiceImpl();
    }

    public Response listAll() {

        List<Projeto> entity = null;

        try {

            entity = service.findAll();
        } catch (Exception e) {
            logger.error("erro", e);
        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@FormParam("nmprojeto") String nmprojeto) {

        String result = null;
        Projeto entity = null;

        try {

            entity = new Projeto();
            entity.setNmprojeto(nmprojeto);
            entity.setEnabled(1);

            service.persist(entity);

            result = "sucesso";
        } catch (Exception e) {
            logger.error("erro", e);
            result = "Error " + e.getMessage();
        } finally {

        }
        return Response.ok(result).build();

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

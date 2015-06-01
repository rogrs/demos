package br.com.demos.restlets.impl;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.TarefaServiceImpl;
import br.com.demos.restlets.TarefaRest;
import br.com.demos.vo.Tarefa;

public class TarefasRestlet implements TarefaRest {

    private static final Logger logger = Logger.getLogger(TarefasRestlet.class);

    private TarefaServiceImpl service = null;

    public TarefasRestlet() {
        service = new TarefaServiceImpl();
    }

    public Response listAll() {

        List<Tarefa> entity = null;

        try {

            entity = service.findAll();
        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@FormParam("tarefa") String tarefa) {

        String result = null;
        Tarefa entity = null;

        try {

            entity = new Tarefa();
            entity.setNmtarefa(tarefa);
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

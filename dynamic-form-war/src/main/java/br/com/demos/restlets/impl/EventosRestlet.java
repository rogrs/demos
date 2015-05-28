package br.com.demos.restlets.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;

import br.com.demos.jpa.service.impl.EventoServiceImpl;
import br.com.demos.restlets.EventoRest;
import br.com.demos.restlets.forms.EventoForm;
import br.com.demos.util.HostInfo;
import br.com.demos.vo.Evento;

public class EventosRestlet implements EventoRest {

   // private static final Logger logger = Logger.getLogger(EventosRestlet.class);

    private EventoServiceImpl service = null;

    public EventosRestlet() {
        service = new EventoServiceImpl();
    }

    private Evento findById(Long id) {

        return service.find(id);
    }

    public Response listAll() {

        List<Evento> entity = null;

        entity = service.findAll();

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form EventoForm form) {

       // String result = null;

        Evento entity = null;

       // try {

            entity = new Evento();
            entity.setHostname(HostInfo.getHostName());
            entity.setUsuario(System.getProperty("user.name"));
            entity.setMsg(form.getMensagem());
            entity.setSistema(form.getSistema());
            entity.setTipo(form.getTipo());
            entity.setDtcreate(new Date());

            service.persist(entity);

          //  result = "sucesso";
     //  } catch (Exception e) {
        //    logger.error("erro", e);
          //  result = "Error " + e.getMessage();
       // } finally {

        //}
        //return Response.ok(result).build();
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    @Override
    public Response getByID(Long id) {
        Evento entity = null;

        entity = findById(id);

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    @Override
    public Response remove(Long id) {

        Evento entity = null;

        entity = findById(id);

        service.remove(entity);

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

}

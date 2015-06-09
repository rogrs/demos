package br.com.demos.restlets.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;

import br.com.demos.jpa.service.impl.GeolocationServiceImpl;
import br.com.demos.restlets.GeolocationRest;
import br.com.demos.restlets.forms.GeolocationForm;
import br.com.demos.vo.Geolocation;



public class GeolocationRestlet implements GeolocationRest {

   // private static final Logger logger = Logger.getLogger(EventosRestlet.class);

    private GeolocationServiceImpl service = null;

    public GeolocationRestlet() {
        service = new GeolocationServiceImpl();
    }

    private Geolocation findById(Long id) {

        return service.find(id);
    }

    public Response listAll() {

        List<Geolocation> entity = null;

        entity = service.findAll();

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form GeolocationForm form) {

       // String result = null;

    	Geolocation entity = null;

       // try {

            entity = new Geolocation();
            entity.setAddress(form.getAddress());
            entity.setIdusuario(form.getIdusuario());
            entity.setMsg(form.getMsg());
            entity.setLongitude(form.getLongitude());
            entity.setLatitude(form.getLatitude());
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
    	Geolocation entity = null;

        entity = findById(id);

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    @Override
    public Response remove(Long id) {

    	Geolocation entity = null;

        entity = findById(id);

        service.remove(entity);

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

}

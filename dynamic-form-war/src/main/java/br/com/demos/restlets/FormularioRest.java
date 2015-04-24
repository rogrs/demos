package br.com.demos.restlets;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;

import br.com.demos.restlets.forms.FormularioForm;

@Path(value = "/v1/formularios/")
public interface FormularioRest {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response listAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getByID(@PathParam("id") Long id);

    @POST
    @Path("/")
    @PermitAll
    @Consumes("application/x-www-form-urlencoded")
    Response create(@Form FormularioForm form);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response remove(@PathParam("id") Long id);

}

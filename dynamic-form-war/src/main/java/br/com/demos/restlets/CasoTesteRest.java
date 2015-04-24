package br.com.demos.restlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/v1/casostestes/")
public interface CasoTesteRest {

    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response listar();
   
    @POST
    @Path("create")
    @Consumes("application/x-www-form-urlencoded")
     Response create(@FormParam("casoteste") String nmcasoteste, @FormParam("idprojeto") String idprojeto);

}

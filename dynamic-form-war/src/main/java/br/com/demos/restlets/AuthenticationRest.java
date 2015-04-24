package br.com.demos.restlets;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;

import br.com.demos.restlets.forms.LoginForm;




@Path(value = "/v1/authentication/")
public interface AuthenticationRest {
    
    
    @POST
    @Path("/session")
    @Produces("application/json; charset=UTF-8")
    Response session(@Form LoginForm form);

    
    
    @PUT
    @Path("/logout")
    @Produces("application/json; charset=UTF-8")
    Response logout(@FormParam("username") String userName);
    
    
    @PUT
    @Path("/credentials")
    @Produces("application/json; charset=UTF-8")
    Response credentials(@FormParam("username") String userName);
    
}

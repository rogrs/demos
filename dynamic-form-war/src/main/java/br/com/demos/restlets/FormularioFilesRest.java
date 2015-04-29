package br.com.demos.restlets;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path(value = "/v1/formulariofiles")
public interface FormularioFilesRest {
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response listAll();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response listByFormulario(@QueryParam("formulario") Long formulario);

    
    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(@QueryParam("formulario") Long formulario ,MultipartFormDataInput input) throws IOException;
    
    
    //http://www.mastertheboss.com/jboss-frameworks/resteasy/using-rest-services-to-manage-download-and-upload-of-files
    
   /* @GET
    @Path("/{fileName}/image")
    @Produces("image/jpeg")
    public Response getFileInJPEGFormat(@PathParam("fileName") String fileName);*/

}

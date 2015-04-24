package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import lombok.Getter;

import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.util.Base64.InputStream;

@Getter
public class FileUploadForm {

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream data;

    @FormParam("user")
    @PartType(MediaType.TEXT_PLAIN)
    private String user;

    @FormParam("password")
    @PartType(MediaType.TEXT_PLAIN)
    private String password;

    @FormParam("filename")
    @PartType(MediaType.TEXT_PLAIN)
    private String filename;

    @FormParam("idformulario")
    private Long idformulario;

    public FileUploadForm() {
    }
}

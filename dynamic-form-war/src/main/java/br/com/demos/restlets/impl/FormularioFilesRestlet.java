package br.com.demos.restlets.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import br.com.demos.jpa.service.impl.FormularioFilesServiceImpl;
import br.com.demos.jpa.service.impl.PropriedadeServiceImpl;
import br.com.demos.restlets.FormularioFilesRest;
import br.com.demos.vo.FormularioFiles;
import br.com.demos.vo.Propriedades;

public class FormularioFilesRestlet implements FormularioFilesRest {

    // http://examples.javacodegeeks.com/enterprise-java/rest/resteasy/resteasy-file-upload-example/
    private static final Logger logger = Logger.getLogger(FormularioFilesRestlet.class);

    private static final String UPLOAD_PATH = "UPLOAD_PATH";

    private Propriedades getPropetyDB(String chave) {
        PropriedadeServiceImpl impl = new PropriedadeServiceImpl();
        return impl.findKey(chave);
    }

    public Response uploadFile(@QueryParam("formulario") Long formulario , MultipartFormDataInput input) throws IOException {
        
        FormularioFilesServiceImpl impl = new FormularioFilesServiceImpl();

        Propriedades property = getPropetyDB(UPLOAD_PATH);

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        
        URI location = null;

        // Get file data to save
        List<InputPart> inputParts = uploadForm.get("attachment");

        for (InputPart inputPart : inputParts) {
            try {

                MultivaluedMap<String, String> header = inputPart.getHeaders();
                String fileName = getFileName(header);

                // convert the uploaded file to inputstream
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                byte[] bytes = IOUtils.toByteArray(inputStream);
                // constructs upload file path
                fileName = property.getValor() + fileName;
                writeFile(bytes, fileName);
                
                FormularioFiles obj =new FormularioFiles();
                obj.setIdformulario(formulario);
                obj.setFilepath(fileName);
                obj.setDtcreate(new Date());
                impl.persist(obj);
                
                location = new URI("../Relatorio.html");
                
                //return Response.status(200).entity("Uploaded file name : " + fileName).build();

            } catch (Exception e) {

                logger.error("Erro uploadFile ", e);
            }
        }
       
        return Response.temporaryRedirect(location).build();
    }

    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

    private void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            // System.out.println("not exist> " + file.getAbsolutePath());
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }

    @Override
    public Response listAll() {
        FormularioFilesServiceImpl impl = null;
        List<FormularioFiles> entity = null;

        try {
            impl = new FormularioFilesServiceImpl();


            entity = impl.findAll();
        } catch (Exception e) {
            logger.error("Erro ao listar formulario", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    @Override
    public Response listByFormulario(Long formulario) {
        FormularioFilesServiceImpl impl = null;
        List<FormularioFiles> entity = null;

        try {
            impl = new FormularioFilesServiceImpl();


            entity = impl.findFilesByFormulario(formulario);
        } catch (Exception e) {
            logger.error("Erro ao listar formulario id="+formulario, e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

}

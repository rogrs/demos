package br.com.demos.restlets.impl;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.Form;

import br.com.demos.jpa.service.impl.UsuariosServiceImpl;
import br.com.demos.restlets.UsuarioRest;
import br.com.demos.restlets.forms.UsuarioForm;
import br.com.demos.util.Owasp;
import br.com.demos.vo.Usuarios;

public class UsuariosRestlet implements UsuarioRest {

    private static final Logger logger = Logger.getLogger(UsuariosRestlet.class);

    public Response listAll() {

        UsuariosServiceImpl impl = null;

        List<Usuarios> entity = null;

        try {
            impl = new UsuariosServiceImpl();

            entity = impl.findAll();
        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form UsuarioForm form) {

        UsuariosServiceImpl impl = null;
        Usuarios entity = null;

        URI location = null;

        try {
            impl = new UsuariosServiceImpl();

            if (form.isValidPassword()) {
                entity = new Usuarios();
                entity.setUsername(form.getUsername());
                entity.setFullname(form.getFullname());
                entity.setPwd(form.getPwd());
                entity.setRole(form.getRole());
                entity.setEnable(1);
                entity.setDtcreate(new Date());

                entity = Owasp.generateHash(entity);

                impl.persist(entity);

                location = new URI("../Usuarios.html");
            }else{
                location = new URI("../Usuario.html"); 
            }

        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }
        return Response.temporaryRedirect(location).build();
        // return Response.ok(result).build();

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

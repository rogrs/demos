package br.com.demos.restlets.impl;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.Form;

import br.com.api.security.util.Hash;
import br.com.demos.jpa.service.impl.UsuariosServiceImpl;
import br.com.demos.restlets.UsuarioRest;
import br.com.demos.restlets.forms.UsuarioForm;
import br.com.demos.vo.Usuarios;

public class UsuariosRestlet implements UsuarioRest {

    private static final Logger logger = Logger.getLogger(UsuariosRestlet.class);

    private UsuariosServiceImpl service = null;

    public UsuariosRestlet() {

        service = new UsuariosServiceImpl();
    }
    

    public Response listAll() {

        List<Usuarios> entity = null;

        try {

            entity = service.findAll();
        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@Form UsuarioForm form) {

        Usuarios entity = null;

        URI location = null;

        try {

            if (form.isValidPassword()) {
                entity = new Usuarios();
                entity.setUsername(form.getUsername());
                entity.setFullname(form.getFullname());
                entity.setRole(form.getRole());
                entity.setEnable(1);
                entity.setDtcreate(new Date());
                entity.setSalt(Hash.userNameKey);
                entity.setPwd(Hash.encrypt(entity.getSalt(),form.getPwd()));

                service.persist(entity);

                location = new URI("../users-list.html");
            } else {
                location = new URI("../users-crud.html");
            }

        } catch (Exception e) {
            logger.error("Erro ao executar create", e);

        } finally {

        }
        return Response.temporaryRedirect(location).build();
    }

    @Override
    public Response getByID(Long id) {

        URI location = null;
        try {

            service.find(id);
            location = new URI("../Usuarios.html");
        } catch (Exception e) {
            logger.error("Erro ao executar getByID " + id, e);
        }

        return Response.temporaryRedirect(location).build();
    }

    @Override
    public Response remove(Long id) {

        Usuarios entity = null;
        URI location = null;
        try {

            entity = new Usuarios(id);
            service.remove(entity);
            location = new URI("../Usuarios.html");
        } catch (Exception e) {
            logger.error("Erro ao executar remove " + id, e);
        }

        return Response.temporaryRedirect(location).build();

    }

}

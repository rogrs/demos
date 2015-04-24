package br.com.demos.restlets.impl;

import java.net.URI;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.UsuariosServiceImpl;
import br.com.demos.restlets.AuthenticationRest;
import br.com.demos.restlets.forms.LoginForm;

public class AuthenticationRestlet implements AuthenticationRest {

    private static final Logger logger = Logger.getLogger(AuthenticationRestlet.class);

    public Response session(LoginForm form) {
        UsuariosServiceImpl impl = null;

       
        URI location = null;
        try {
            impl = new UsuariosServiceImpl();

            if (impl.authenticate(form.getUsername(), form.getUserPass())) {
              
                location = new URI("../Relatorio.html");
            } else {
                location = new URI("../Home.html");
            }

        } catch (Exception e) {
            logger.error("erro", e);

        }
        return Response.temporaryRedirect(location).build();

        // return Response.ok(result).build();
        // return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    @Override
    public Response logout(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response credentials(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}
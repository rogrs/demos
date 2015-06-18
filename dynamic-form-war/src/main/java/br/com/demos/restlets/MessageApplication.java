package br.com.demos.restlets;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.demos.restlets.impl.AuthenticationRestlet;
import br.com.demos.restlets.impl.CasosTestesRestlet;
import br.com.demos.restlets.impl.EventosRestlet;
import br.com.demos.restlets.impl.FormularioFilesRestlet;
import br.com.demos.restlets.impl.FormulariosRestlet;
import br.com.demos.restlets.impl.GeolocationRestlet;
import br.com.demos.restlets.impl.PerguntasRestlet;
import br.com.demos.restlets.impl.ProjetosRestlet;
import br.com.demos.restlets.impl.PropriedadesRestlet;
import br.com.demos.restlets.impl.TarefasRestlet;
import br.com.demos.restlets.impl.UsuariosRestlet;



@ApplicationPath("/rs")
public class MessageApplication extends Application {

   
    
    private Set<Object> singletons = new HashSet<Object>();

    public MessageApplication() {
            singletons.add(new CasosTestesRestlet());
            singletons.add(new EventosRestlet());
            singletons.add(new ProjetosRestlet());
            singletons.add(new PropriedadesRestlet());
            singletons.add(new TarefasRestlet());
            singletons.add(new PerguntasRestlet());
            singletons.add(new FormulariosRestlet());
            singletons.add(new UsuariosRestlet());  
            singletons.add(new FormularioFilesRestlet());
            singletons.add(new AuthenticationRestlet());
            singletons.add(new GeolocationRestlet());
    }

    @Override
    public Set<Object> getSingletons() {
            return singletons;
    }
    
 }
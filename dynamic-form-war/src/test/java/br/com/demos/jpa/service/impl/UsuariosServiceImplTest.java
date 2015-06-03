package br.com.demos.jpa.service.impl;

import org.junit.Test;

public class UsuariosServiceImplTest {
    
    
    @Test
    public void testlogin(){
        String login = "admin";
        String password  = "admin2015";
        UsuariosServiceImpl service;
        try {
            service = new UsuariosServiceImpl();
       
            service.authenticate(login, password);
        } catch (Exception  e) {
          
            e.printStackTrace();
        }
        
        
    }

}

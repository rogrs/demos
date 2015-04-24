package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class EventoForm {
    
    @FormParam("mensagem")
    private String mensagem;
    @FormParam("sistema")
    private String sistema;
    @FormParam("tipo")
    private String tipo;
    
    
    
    
   
}

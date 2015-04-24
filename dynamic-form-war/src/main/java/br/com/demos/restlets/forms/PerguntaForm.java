package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class PerguntaForm {
    
    @FormParam("pergunta")
    private String pergunta;
    @FormParam("sequencia")
    private int sequencia;
    @FormParam("componente")
    private String componente;
    
    
    
    
   
}

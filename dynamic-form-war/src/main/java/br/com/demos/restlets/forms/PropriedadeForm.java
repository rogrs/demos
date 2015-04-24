package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class PropriedadeForm {
    
    @FormParam("chave")
    private String chave;
    @FormParam("valor")
    private String valor;
    
 

}

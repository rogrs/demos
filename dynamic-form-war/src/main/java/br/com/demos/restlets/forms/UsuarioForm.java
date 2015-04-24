package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class UsuarioForm {
    
    @FormParam("username")
    private String username;
    @FormParam("fullname")
    private String fullname;
    @FormParam("pwd")
    private String pwd;
    @FormParam("newpwd")
    private String newpwd;
    @FormParam("role")
    private String role;
    
   public boolean isValidPassword(){
       return newpwd.equals(pwd);
   }
   
}

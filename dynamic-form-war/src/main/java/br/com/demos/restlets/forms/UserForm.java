package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class UserForm extends AuthenticationForm{
    
    @FormParam("fullname")
    private String fullname;
    
    @FormParam("email")
    private String email;
    
    @FormParam("confirmPassword")
    private String confirmPassword;
    
    @FormParam("role")
    private String role;
    
    
    public boolean isValidPassword(){
        
        return this.confirmPassword.equals(super.getActualPassword());
    }
     
}
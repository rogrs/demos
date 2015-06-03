package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;


@Getter
public class LoginForm {
    
   
    @FormParam("fullname")
    private String fullname;

    @FormParam("newPassword")
    private String newPassword;

    @FormParam("userPass")
    private String userPass;

    @FormParam("username")
    private String username;

    public boolean isValid() {
        return username != null && userPass != null;
    }


}

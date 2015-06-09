package br.com.demos.restlets.forms;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class AuthenticationForm {

    @FormParam("username")
    private String username;

    @FormParam("actualPassword")
    private String actualPassword;

    public boolean isValid() {
        return username != null && actualPassword != null;
    }

}
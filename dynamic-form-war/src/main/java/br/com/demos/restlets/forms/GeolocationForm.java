package br.com.demos.restlets.forms;

import java.util.Date;

import javax.ws.rs.FormParam;

import lombok.Getter;

@Getter
public class GeolocationForm {

    @FormParam("dtcreate")
    private Date dtcreate;
    @FormParam("idusuario")
    private long idusuario;
    @FormParam("address")
    private String address;
    @FormParam("msg")
    private String msg;
    @FormParam("latitude")
    private float latitude;
    @FormParam("longitude")
    private float longitude;

}

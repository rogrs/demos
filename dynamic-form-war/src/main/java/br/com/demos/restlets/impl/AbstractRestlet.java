package br.com.demos.restlets.impl;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

//http://howtodoinjava.com/2013/06/26/jax-rs-resteasy-basic-authentication-and-authorization-tutorial/

public class AbstractRestlet {
    
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());;
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());;
    private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());;

}

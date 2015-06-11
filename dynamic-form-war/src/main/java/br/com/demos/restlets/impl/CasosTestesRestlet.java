package br.com.demos.restlets.impl;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.CasoTesteServiceImpl;
import br.com.demos.restlets.CasoTesteRest;
import br.com.demos.vo.CasoTestes;

public class CasosTestesRestlet implements CasoTesteRest {

    private static final Logger logger = Logger.getLogger(CasosTestesRestlet.class);

    private CasoTesteServiceImpl service;

    public CasosTestesRestlet() {
        service = new CasoTesteServiceImpl();
    }

    public Response listar() {

        List<CasoTestes> entity = null;

        try {

            entity = service.findAll();

        } catch (Exception e) {
            logger.error("erro", e);

        } finally {

        }

        return Response.ok(entity, MediaType.APPLICATION_JSON).build();

    }

    public Response create(@FormParam("casoteste") String nmcasoteste, @FormParam("idprojeto") String idprojeto) {

        String result = null;

        CasoTestes entity = null;
        Long projeto = null;
        try {
            projeto = Long.parseLong(idprojeto);
        } catch (NumberFormatException e) {
            result = "Erro ao informar número do projeto";
        }

        try {

            entity = new CasoTestes();
            entity.setCasoteste(nmcasoteste);
            entity.setIdprojeto(projeto);
            entity.setEnabled(1);

            service.persist(entity);

            result = "sucesso";
        } catch (Exception e) {
            logger.error("erro", e);
            result = "Error " + e.getMessage();
        } finally {

        }
        return Response.ok(result).build();

    }

}

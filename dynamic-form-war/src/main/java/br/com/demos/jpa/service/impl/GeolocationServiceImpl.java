package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Geolocation;


public class GeolocationServiceImpl extends GenericDAOJPA<Geolocation, Long> implements GenericJPAService<Geolocation> {
    

    public List<Geolocation> findByName(String address) {
        
        String sql = "SELECT g FROM Geolocation g WHERE g.address = :address";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("chave", address);
        return findQuery(sql, params);
    
    }
    
}

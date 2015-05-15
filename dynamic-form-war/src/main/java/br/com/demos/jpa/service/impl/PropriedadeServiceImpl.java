package br.com.demos.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.demos.vo.Propriedades;

public class PropriedadeServiceImpl extends GenericDAOJPA<Propriedades, Long> implements GenericJPAService<Propriedades> {
    

    public List<Propriedades> findByName(String key) {
        
        String sql = "SELECT p FROM Propriedades p WHERE p.chave = :chave and p.enabled =1";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("chave", key);
        return findQuery(sql, params);
    
    }
    
 
    
 public Propriedades findKey(String key) {
        
        String sql = "SELECT p FROM Propriedades p WHERE p.chave = :chave and p.enabled =1";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("chave", key);
        Propriedades prop = null;
        List<Propriedades> propriedades = findQuery(sql, params);
        
        for (Propriedades p: propriedades){
            prop = p; 
        }
        
        return prop;
    
    }
    
 

}

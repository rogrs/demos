package br.com.demos.util;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ID {
    
    private Long value;
    
    public ID(String param){
        try {
            
        
        value = Long.parseLong(param);
        
        } catch (Exception e){
            value = 0l;
        }
    }

}

package br.com.demos;

import java.security.GeneralSecurityException;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.api.security.util.Hash;

public class HashTest {
    
    
    private static final Logger LOGGER = Logger.getLogger(HashTest.class);
    
    @Test
    public void test(){
        String salt = Hash.userNameKey;
        try {
            String encrypted = Hash.encrypt(salt, "admin2015");
            LOGGER.info("salt="+salt);
            LOGGER.info("encrypted="+encrypted);
            LOGGER.info("decrypt "+Hash.decrypt(salt,encrypted));
        } catch (GeneralSecurityException e) {
            LOGGER.error("Erro ao excutar decrypt",e);
        }
        
     
    }

}

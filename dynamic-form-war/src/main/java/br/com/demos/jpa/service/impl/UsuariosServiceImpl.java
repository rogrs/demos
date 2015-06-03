package br.com.demos.jpa.service.impl;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import br.com.api.persistence.generic.GenericDAOJPA;
import br.com.api.persistence.service.GenericJPAService;
import br.com.api.security.util.Hash;
import br.com.demos.vo.Usuarios;

public class UsuariosServiceImpl extends GenericDAOJPA<Usuarios, Long> implements GenericJPAService<Usuarios> {


    private static final Logger logger = Logger.getLogger(UsuariosServiceImpl.class);

    @Override
    public List<Usuarios> findByName(String userName) {
        String sql = "SELECT u FROM Usuarios u WHERE u.username = :username";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", userName);
        return findQuery(sql, params);

    }

    public List<Usuarios> findBySession(String userName, String pwd) {

        String sql = "SELECT u FROM Usuarios u WHERE u.username = :username and u.pwd = :pwd";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", userName);
        params.put("pwd", pwd);
        return findQuery(sql, params);

    }

    public Usuarios authenticate(String login, String password) throws NoSuchAlgorithmException {

        List<Usuarios> listUsers = null;
        Usuarios user = null;


        listUsers = this.findByName(login);
        user = listUsers.get(0);

        if (user != null) {

            try {
                
                String decrypt = Hash.decrypt(user.getSalt(),user.getPwd());
                if (!password.equals(decrypt)){
                    user = null;
                    user = new Usuarios("Senha incorreta!"); 
                    logger.info("Senha incorreta! ");
                }
            } catch (GeneralSecurityException e) {
                logger.error("GeneralSecurityException",e);
            }

        }else {
            user = new Usuarios("Usuário não existe"); 
            logger.info("Usuário não existe "+login);
        }

        return user;

    }

}

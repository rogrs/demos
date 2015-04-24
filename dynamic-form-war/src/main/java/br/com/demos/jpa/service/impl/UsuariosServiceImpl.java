package br.com.demos.jpa.service.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import br.com.demos.jpa.generic.GenericDAOJPA;
import br.com.demos.jpa.service.GenericJPAService;
import br.com.demos.util.Owasp;
import br.com.demos.vo.Usuarios;

public class UsuariosServiceImpl extends GenericDAOJPA<Usuarios, Long> implements GenericJPAService<Usuarios> {
    
    private final static int ITERATION_NUMBER = 1000;

    @Override
    public List<Usuarios> findByName(String userName) {
        String sql = "SELECT u FROM Usuarios u WHERE u.username = :username" ;

        return super.entityManager.createQuery(sql, Usuarios.class)
                .setParameter("username", userName).getResultList();

    }
    
    public List<Usuarios> findBySession(String userName, String pwd){
        
        
 
        String sql = "SELECT u FROM Usuarios u WHERE u.username = :username and u.pwd = :pwd";
 
        return super.entityManager.createQuery(sql, Usuarios.class)
                .setParameter("username", userName).setParameter("pwd", pwd).getResultList();

    }
    
    
    public boolean authenticate(String login, String password)
            throws  NoSuchAlgorithmException{
        //boolean authenticated=false;
        List<Usuarios> listUsers =null;
        Usuarios users = null;
            boolean userExist = true;
  
            if (login==null||password==null){
                userExist = false;
                login="";
                password="";
            }
 
            listUsers =  this.findByName(login);
            users = listUsers.get(0);
            String digest, salt;
            if (users != null) {
                digest = users.getPwd();
                salt = users.getSalt();
            } else { // TIME RESISTANT ATTACK (Even if the user does not exist the
                // Computation time is equal to the time needed for a legitimate user
                digest = "000000000000000000000000000=";
                salt = "00000000000=";
                userExist = false;
            }
  
            byte[] bDigest = null;
            try {
                bDigest = Owasp.base64ToByte(digest);
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            byte[] bSalt = null;
            try {
                bSalt = Owasp.base64ToByte(salt);
            } catch (IOException e) {
                
                e.printStackTrace();
            }
  
            // Compute the new DIGEST
            byte[] proposedDigest = Owasp.getHash(ITERATION_NUMBER, password, bSalt);
  
            return Arrays.equals(proposedDigest, bDigest) && userExist;
        
    }

}

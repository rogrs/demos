package br.com.demos.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.demos.jpa.service.impl.UsuariosServiceImpl;
import br.com.demos.vo.Usuarios;


public class UsersJpaControllerTest extends TestCase {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public UsersJpaControllerTest(String testName) {
        super(testName);
    }
    
    
    @BeforeClass
    public static void initTestFixture() throws Exception {
       
        emf = Persistence.createEntityManagerFactory("demo-pu");
        em = emf.createEntityManager();
     
    }

 
    @AfterClass
    public static void closeTestFixture() {
        em.close();
        emf.close();
    }
   
    
    public void testeAutenticar(){
        
       UsuariosServiceImpl impl = new UsuariosServiceImpl();
        
       String userName = "admin";
       String pwd = "admin2015";
        
       impl.setEntityManager(em);
       List<Usuarios> users =   impl.findBySession(userName, pwd);
       
       assertEquals(users.size(), 1);
    }

    
    
    public void listarUsuarios(){
        
        UsuariosServiceImpl impl = new UsuariosServiceImpl();
        
       
        
        impl.setEntityManager(em);
        List<Usuarios>  users =   impl.findAll();
        
        System.out.println("Found " + users.size() + " usuarios:");
        for (Usuarios p : users){
            
            System.out.println(p);
        }
        
    }
    
}

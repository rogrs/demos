package br.com.demos.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import br.com.demos.jpa.service.impl.ProjetoServiceImpl;
import br.com.demos.vo.Projeto;

@Ignore
public class ProjetoJpaControllerTest extends TestCase {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public ProjetoJpaControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(ProjetoJpaControllerTest.class);
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


/*   public void criarProjeto() {

        long init = System.currentTimeMillis();
        Projeto obj = new Projeto();
        ProjetoJpaController con = new ProjetoJpaController(emf);

        obj.setNmprojeto("Projeto de Teste " + new Date());
        obj.setEnabled(1);
        obj.setDtcreate(new Date());

        long durationInMillis = System.currentTimeMillis() - init;

        con.create(obj);
        
        
    }*/

  public void teste(){
       
       ProjetoServiceImpl impl = new ProjetoServiceImpl();
       
      
       
       impl.setEntityManager(em);
       List<Projeto>  projetos =   impl.findAll();
       
       System.out.println("Found " + projetos.size() + " projetos:");
       for (Projeto p : projetos){
           
           System.out.println(p);
       }
       
   }
   

}

package br.com.demos;

import java.io.IOException;

import br.com.demos.util.RunCommand;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        
        RunCommand run = new RunCommand();
        try {
            
 
            String pathSikuli = "java -jar sikuli-ide.jar ";
            String fileScriptSikuli = "sikuli.sikuli";
            run.execute(pathSikuli+fileScriptSikuli);
        } catch (IOException e) {
         
            e.printStackTrace();
        }
        assertTrue(true);
    }
}

package br.com.demos.jpa.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.demos.vo.Perguntas;
import br.com.demos.vo.PerguntaValues;

public class PerguntaServiceImplTest {
    
    private static final Logger LOGGER = Logger.getLogger(PerguntaServiceImplTest.class);
    @Test
    public void testListAllPerguntas(){
        
        PerguntaValuesServiceImpl serviceValues = new PerguntaValuesServiceImpl();
        PerguntaServiceImpl service = new PerguntaServiceImpl();
        List<Perguntas> perguntas =  service.findAll();
        
        
        
        for (Perguntas pergunta: perguntas){
            LOGGER.info(pergunta);
            LOGGER.info(pergunta.getComponente());
            List<PerguntaValues> perguntaValues =  null;
            perguntaValues =  serviceValues.findPergunta(pergunta);
            for (PerguntaValues values: perguntaValues){
                LOGGER.info(values);
            }
        }
    }

}

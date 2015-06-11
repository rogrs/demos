package br.com.demos.cvs;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.api.commons.cvs.exception.CVSFileException;
import br.com.api.commons.init.CsvFileReader;
import br.com.demos.vo.CasoTestes;
import br.com.demos.vo.Projetos;
import br.com.demos.vo.Tarefas;

public class CsvWriteReadTest {

    private static final Logger LOGGER = Logger.getLogger(CsvWriteReadTest.class);

    @Test
    public void readFileCVSCasoTeste() {
        String fileName = System.getProperty("user.home") + "/casoteste.csv";

        final File file = new File(fileName);
        List<CasoTestes> casosTestes = null;

        final String delimiter = ";";
        final String encoding = "ISO-8859-1";
        final String[] fields = new String[] { "CASOTESTE", "DATA" };

        LOGGER.info("Write CSV file: " + fileName);

        final CsvFileReader parser = new CsvFileReader(delimiter, encoding, fields);

        try {
            Map<String, List<String>> map = parser.toMap(file);

            casosTestes = new ArrayList<CasoTestes>();

            for (int i = 0; i < map.get(fields[0]).size(); i++) {

                CasoTestes obj = new CasoTestes(map.get("CASOTESTE").get(i).trim());
                casosTestes.add(obj);
            }

        } catch (CVSFileException e) {

            LOGGER.error("Erro CVSFileException ", e);
        }
        LOGGER.info("Total de linhas " + casosTestes.size());
        assertFalse(casosTestes.isEmpty());

    }

    @Test
    public void readFileCVSTarefa() {
        String fileName = System.getProperty("user.home") + "/tarefa.csv";

        final File file = new File(fileName);
        List<Tarefas> tarefas = null;

        final String delimiter = ";";
        final String encoding = "ISO-8859-1";
        final String[] fields = new String[] { "TAREFA", "DATA" };

        LOGGER.info("Write CSV file: " + fileName);

        final CsvFileReader parser = new CsvFileReader(delimiter, encoding, fields);

        try {
            Map<String, List<String>> map = parser.toMap(file);

            tarefas = new ArrayList<Tarefas>();

            for (int i = 0; i < map.get(fields[0]).size(); i++) {

                Tarefas obj = new Tarefas(map.get("TAREFA").get(i).trim());
                tarefas.add(obj);
            }

        } catch (CVSFileException e) {

            LOGGER.error("Erro CVSFileException ", e);
        }

        LOGGER.info("Total de linhas " + tarefas.size());
        assertFalse(tarefas.isEmpty());

    }

    @Test
    public void readFileCVSProjeto() {
        String fileName = System.getProperty("user.home") + "/projeto.csv";

        final File file = new File(fileName);
        List<Projetos> projetos = null;

        final String delimiter = ";";
        final String encoding = "ISO-8859-1";
        final String[] fields = new String[] { "PROJETO", "DATA" };

        LOGGER.info("Write CSV file: " + fileName);

        final CsvFileReader parser = new CsvFileReader(delimiter, encoding, fields);

        try {
            Map<String, List<String>> map = parser.toMap(file);

            projetos = new ArrayList<Projetos>();

            for (int i = 0; i < map.get(fields[0]).size(); i++) {

                Projetos obj = new Projetos(map.get("PROJETO").get(i).trim());
                projetos.add(obj);
            }

        } catch (CVSFileException e) {

            LOGGER.error("Erro CVSFileException ", e);
        }
        LOGGER.info("Total de linhas " + projetos.size());
        assertFalse(projetos.isEmpty());

    }

}

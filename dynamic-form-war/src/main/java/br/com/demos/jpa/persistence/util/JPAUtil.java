package br.com.demos.jpa.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public class JPAUtil {

    private static final Logger LOGGER = Logger.getLogger(JPAUtil.class);

    private static String DEFAULT_PERSISTENCE_UNIT = "demo-pu";

    @PersistenceContext(unitName = "demo-pu")
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static void closeEntityManager() {

        try {
            if (em.isOpen()) {
                em.close();
            }

        } catch (Exception e) {
            LOGGER.error("Erro ao executar closeEntityManager() ", e);
        }
    }

    public static EntityManager createEntityManager() {

        if (em == null || !em.isOpen()) {
            emf = createManagerFactory();
            return em = emf.createEntityManager();
        } else {
            return em;
        }
    }

    public static EntityManagerFactory createManagerFactory() {
        return createManagerFactory(DEFAULT_PERSISTENCE_UNIT);
    }

    public static EntityManagerFactory createManagerFactory(String pu) {

        return emf = Persistence.createEntityManagerFactory(pu);

    }
}

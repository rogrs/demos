package br.com.demos.jpa.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.demos.jpa.persistence.util.JPAUtil;

public abstract class GenericDAOJPA<T, ID extends Serializable> {

    private static final Logger logger = Logger.getLogger(GenericDAOJPA.class);

    private Class<T> persistentClass;

    protected EntityManager entityManager;

    private final static int DEFAULT_RECORD_LINES = 30;

    @SuppressWarnings("unchecked")
    public GenericDAOJPA() {
        this.setEntityManager(null);
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public long count() {
        return (Long) entityManager.createQuery("Select count(t) from " + persistentClass.getSimpleName() + " t").getSingleResult();
    }

    public T find(ID id) {
        return entityManager.find(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> findInRange(int firstResult, int maxResults) {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").setFirstResult(firstResult)
                .setMaxResults(maxResults).getResultList();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void merge(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void mergeBacth(List<T> lista) {

        try {
            entityManager.getTransaction().begin();

            for (T entity : lista) {
                entityManager.merge(entity);
                if (lista.size() % DEFAULT_RECORD_LINES == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }

            }
        } catch (Exception e) {

            entityManager.getTransaction().rollback();

            logger.error("Erro ao executar mergeBacth", e);
        } finally {
            entityManager.getTransaction().commit();
        }

    }

    public void persist(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Erro ao executar persist()", e);
        }

    }

    public void persistBacth(List<T> lista) {

        try {
            entityManager.getTransaction().begin();

            for (T entity : lista) {
                entityManager.persist(entity);
                if (lista.size() % DEFAULT_RECORD_LINES == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }

            }
        } catch (Exception e) {

            entityManager.getTransaction().rollback();

            logger.error("Erro ao executar persistBacth", e);
        } finally {
            entityManager.getTransaction().commit();
        }

    }

    public void remove(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void setEntityManager(EntityManager entityManager) {

        this.entityManager = JPAUtil.createEntityManager();

    }

}
package br.com.demos.jpa.service;

import java.util.List;

public interface GenericJPAService<T>{

    List<T> findAll();

    List<T> findByName(String name);

    void persist(T entity);

    void merge(T entity);

    void remove(T entity);

    T find(Long id);
  
  


}

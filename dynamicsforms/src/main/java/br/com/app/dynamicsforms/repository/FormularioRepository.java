package br.com.app.dynamicsforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.dynamicsforms.model.Formulario;

@RepositoryRestResource(collectionResourceRel = "formularioRel", path = "formulario")
public interface  FormularioRepository extends JpaRepository<Formulario, Long> {

	
}
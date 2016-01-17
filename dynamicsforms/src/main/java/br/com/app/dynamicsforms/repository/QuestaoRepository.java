package br.com.app.dynamicsforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.dynamicsforms.model.Questao;

@RepositoryRestResource(collectionResourceRel = "questaoRel", path = "questao")
public interface  QuestaoRepository extends JpaRepository<Questao, Long> {

	
}
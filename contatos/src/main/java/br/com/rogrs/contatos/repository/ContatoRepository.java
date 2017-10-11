package br.com.rogrs.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogrs.contatos.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

package br.com.app.dynamicsforms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EntityListeners(EntitySuper.class)
public class Formulario extends EntitySuper{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "titulo", nullable = false)
    private String titulo;

}

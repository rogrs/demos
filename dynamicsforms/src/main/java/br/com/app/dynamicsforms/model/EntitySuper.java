package br.com.app.dynamicsforms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntitySuper extends AbstractPersistable<Long>{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "criado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criado;	
	
	@Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;

}

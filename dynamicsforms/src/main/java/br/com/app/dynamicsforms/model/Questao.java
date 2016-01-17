package br.com.app.dynamicsforms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.app.dynamicsforms.model.enums.TipoQuestao;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EntityListeners(EntitySuper.class)
public class Questao extends EntitySuper{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pergunta", nullable = false)
    private String pergunta;
	@Column(name = "resposta")
    private String resposta;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoQuestao tipo;
    
    @JoinColumn(name = "formulario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Formulario formulario;

}

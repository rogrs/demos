package br.com.demos.vo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "perguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perguntas.findAll", query = "SELECT p FROM Perguntas p"),
    @NamedQuery(name = "Perguntas.findById", query = "SELECT p FROM Perguntas p WHERE p.id = :id"),
    @NamedQuery(name = "Perguntas.findByPergunta", query = "SELECT p FROM Perguntas p WHERE p.pergunta = :pergunta"),
    @NamedQuery(name = "Perguntas.findByComponente", query = "SELECT p FROM Perguntas p WHERE p.componente = :componente"),
    @NamedQuery(name = "Perguntas.findBySequencia", query = "SELECT p FROM Perguntas p WHERE p.sequencia = :sequencia"),
    @NamedQuery(name = "Perguntas.findByIdformulario", query = "SELECT p FROM Perguntas p WHERE p.idformulario = :idformulario")})
@Getter
@Setter
public class Perguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "pergunta")
    private String pergunta;
    @Column(name = "componente")
    private String componente;
    @Column(name = "sequencia")
    private Integer sequencia;
    @Basic(optional = false)
    @Column(name = "idformulario")
    private long idformulario;

    public Perguntas() {
    }

    public Perguntas(Long id) {
        this.id = id;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perguntas)) {
            return false;
        }
        Perguntas other = (Perguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.Perguntas[ id=" + id + " ]";
    }
    
}

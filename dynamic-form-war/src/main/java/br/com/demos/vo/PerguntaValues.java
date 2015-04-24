
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
@Table(name = "pergunta_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerguntaValues.findAll", query = "SELECT p FROM PerguntaValues p"),
    @NamedQuery(name = "PerguntaValues.findById", query = "SELECT p FROM PerguntaValues p WHERE p.id = :id"),
    @NamedQuery(name = "PerguntaValues.findByIdpergunta", query = "SELECT p FROM PerguntaValues p WHERE p.idpergunta = :idpergunta"),
    @NamedQuery(name = "PerguntaValues.findByChave", query = "SELECT p FROM PerguntaValues p WHERE p.chave = :chave"),
    @NamedQuery(name = "PerguntaValues.findByValor", query = "SELECT p FROM PerguntaValues p WHERE p.valor = :valor")})
@Getter
@Setter
public class PerguntaValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idpergunta")
    private long idpergunta;
    @Basic(optional = false)
    @Column(name = "chave")
    private String chave;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;

    public PerguntaValues() {
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
        if (!(object instanceof PerguntaValues)) {
            return false;
        }
        PerguntaValues other = (PerguntaValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.PerguntaValues[ id=" + id + " ]";
    }
    
}

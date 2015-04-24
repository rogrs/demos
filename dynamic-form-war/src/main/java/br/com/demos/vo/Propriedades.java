package br.com.demos.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "propriedades")
@XmlRootElement
@Getter
@Setter
public class Propriedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "chave", length = 255)
    private String chave;
    @Basic(optional = false)
    @Column(name = "valor", length =1024)
    private String valor;
    @Column(name = "enabled")
    private Integer enabled;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;

    public Propriedades() {
    }

    public Propriedades(Long id) {
        this.id = id;
    }

    public Propriedades(Long id, String chave, String valor, Date dtcreate) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
        this.dtcreate = dtcreate;
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
        if (!(object instanceof Propriedades)) {
            return false;
        }
        Propriedades other = (Propriedades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.chave+" "+this.valor;
    }
    
}

package br.com.demos.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "propriedades")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Propriedades.findAll", query = "SELECT p FROM Propriedades p"),
        @NamedQuery(name = "Propriedades.findById", query = "SELECT p FROM Propriedades p WHERE p.id = :id"),
        @NamedQuery(name = "Propriedades.findByChave", query = "SELECT p FROM Propriedades p WHERE p.chave = :chave"),
        @NamedQuery(name = "Propriedades.findByEnabled", query = "SELECT p FROM Propriedades p WHERE p.enabled = :enabled"),
        @NamedQuery(name = "Propriedades.findByValor", query = "SELECT p FROM Propriedades p WHERE p.valor = :valor"),
        @NamedQuery(name = "Propriedades.findByDtcreate", query = "SELECT p FROM Propriedades p WHERE p.dtcreate = :dtcreate") })
@Getter
@Setter
public class Propriedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "chave")
    private String chave;
    @Column(name = "enabled")
    private Integer enabled;
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;

    public Propriedades() {
    }

    public Propriedades(Long id) {
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
        return this.chave;
    }

}

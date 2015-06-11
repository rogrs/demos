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
@Table(name = "formularios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formularios.findAll", query = "SELECT f FROM Formularios f"),
    @NamedQuery(name = "Formularios.findById", query = "SELECT f FROM Formularios f WHERE f.id = :id"),
    @NamedQuery(name = "Formularios.findByFormulario", query = "SELECT f FROM Formularios f WHERE f.formulario = :formulario"),
    @NamedQuery(name = "Formularios.findByDtcreate", query = "SELECT f FROM Formularios f WHERE f.dtcreate = :dtcreate"),
    @NamedQuery(name = "Formularios.findByEnabled", query = "SELECT f FROM Formularios f WHERE f.enabled = :enabled")})
@Getter
@Setter
public class Formularios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "formulario")
    private String formulario;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;

    public Formularios() {
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
        if (!(object instanceof Formularios)) {
            return false;
        }
        Formularios other = (Formularios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.formulario;
    }
    
}

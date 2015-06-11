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
@Table(name = "projetos")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Projetos.findAll", query = "SELECT p FROM Projetos p"),
        @NamedQuery(name = "Projetos.findById", query = "SELECT p FROM Projetos p WHERE p.id = :id"),
        @NamedQuery(name = "Projetos.findByProjeto", query = "SELECT p FROM Projetos p WHERE p.projeto = :projeto"),
        @NamedQuery(name = "Projetos.findByDtcreate", query = "SELECT p FROM Projetos p WHERE p.dtcreate = :dtcreate"),
        @NamedQuery(name = "Projetos.findByEnabled", query = "SELECT p FROM Projetos p WHERE p.enabled = :enabled") })
@Getter
@Setter
public class Projetos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "projeto")
    private String projeto;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;

    public Projetos() {
    }

    public Projetos(Long id) {
        this.id = id;
    }

    public Projetos(String projeto) {
       this.projeto= projeto;
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
        if (!(object instanceof Projetos)) {
            return false;
        }
        Projetos other = (Projetos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.projeto;
    }

}

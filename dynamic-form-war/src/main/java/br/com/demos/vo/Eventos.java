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
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findById", query = "SELECT e FROM Eventos e WHERE e.id = :id"),
    @NamedQuery(name = "Eventos.findByDtcreate", query = "SELECT e FROM Eventos e WHERE e.dtcreate = :dtcreate"),
    @NamedQuery(name = "Eventos.findByHostname", query = "SELECT e FROM Eventos e WHERE e.hostname = :hostname"),
    @NamedQuery(name = "Eventos.findByMsg", query = "SELECT e FROM Eventos e WHERE e.msg = :msg"),
    @NamedQuery(name = "Eventos.findBySistema", query = "SELECT e FROM Eventos e WHERE e.sistema = :sistema"),
    @NamedQuery(name = "Eventos.findByTipo", query = "SELECT e FROM Eventos e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Eventos.findByUsuario", query = "SELECT e FROM Eventos e WHERE e.usuario = :usuario")})
@Getter
@Setter
public class Eventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Column(name = "hostname")
    private String hostname;
    @Column(name = "msg")
    private String msg;
    @Column(name = "sistema")
    private String sistema;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "usuario")
    private String usuario;

    public Eventos() {
    }

    public Eventos(Long id) {
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
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.Eventos[ id=" + id + " ]";
    }
    
}

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
@Table(name = "casotestes")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Casotestes.findAll", query = "SELECT c FROM Casotestes c"),
        @NamedQuery(name = "Casotestes.findById", query = "SELECT c FROM Casotestes c WHERE c.id = :id"),
        @NamedQuery(name = "Casotestes.findByCasoteste", query = "SELECT c FROM Casotestes c WHERE c.casoteste = :casoteste"),
        @NamedQuery(name = "Casotestes.findByDtcreate", query = "SELECT c FROM Casotestes c WHERE c.dtcreate = :dtcreate"),
        @NamedQuery(name = "Casotestes.findByEnabled", query = "SELECT c FROM Casotestes c WHERE c.enabled = :enabled"),
        @NamedQuery(name = "Casotestes.findByIdprojeto", query = "SELECT c FROM Casotestes c WHERE c.idprojeto = :idprojeto") })
@Getter
@Setter
public class CasoTestes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "casoteste")
    private String casoteste;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;
    @Basic(optional = false)
    @Column(name = "idprojeto")
    private long idprojeto;

    public CasoTestes() {
    }

    public CasoTestes(Long id) {
        this.id = id;
    }

    public CasoTestes(String casoteste) {
        this.casoteste = casoteste;
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
        if (!(object instanceof CasoTestes)) {
            return false;
        }
        CasoTestes other = (CasoTestes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.Casotestes[ id=" + id + " ]";
    }

}

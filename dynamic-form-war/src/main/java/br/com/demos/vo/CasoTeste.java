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
@Table(name = "casoteste")
@XmlRootElement
@Getter
@Setter
public class CasoTeste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "idprojeto")
    private Long idprojeto;
    @Basic(optional = false)
    @Column(name = "nmcasoteste")
    private String nmcasoteste;
    @Column(name = "enabled")
    private Integer enabled;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;

    public CasoTeste() {
    }

    public CasoTeste(Long id) {
        this.id = id;
    }

    public CasoTeste(Long id, String nmcasoteste, Date dtcreate) {
        this.id = id;
        this.nmcasoteste = nmcasoteste;
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
        if (!(object instanceof CasoTeste)) {
            return false;
        }
        CasoTeste other = (CasoTeste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nmcasoteste;
    }
    
}

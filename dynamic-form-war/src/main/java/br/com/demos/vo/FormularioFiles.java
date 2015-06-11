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
@Table(name = "formulario_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormularioFiles.findAll", query = "SELECT f FROM FormularioFiles f"),
    @NamedQuery(name = "FormularioFiles.findById", query = "SELECT f FROM FormularioFiles f WHERE f.id = :id"),
    @NamedQuery(name = "FormularioFiles.findByIdformulario", query = "SELECT f FROM FormularioFiles f WHERE f.idformulario = :idformulario"),
    @NamedQuery(name = "FormularioFiles.findByFilepath", query = "SELECT f FROM FormularioFiles f WHERE f.filepath = :filepath"),
    @NamedQuery(name = "FormularioFiles.findByDtcreate", query = "SELECT f FROM FormularioFiles f WHERE f.dtcreate = :dtcreate")})
@Getter
@Setter
public class FormularioFiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idformulario")
    private long idformulario;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;

    public FormularioFiles() {
    }

    public FormularioFiles(Long id) {
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
        if (!(object instanceof FormularioFiles)) {
            return false;
        }
        FormularioFiles other = (FormularioFiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.FormularioFiles[ id=" + id + " ]";
    }
    
}

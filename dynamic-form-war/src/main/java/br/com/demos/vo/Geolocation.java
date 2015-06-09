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
@Table(name = "geolocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geolocation.findAll", query = "SELECT g FROM Geolocation g"),
    @NamedQuery(name = "Geolocation.findById", query = "SELECT g FROM Geolocation g WHERE g.id = :id"),
    @NamedQuery(name = "Geolocation.findByDtcreate", query = "SELECT g FROM Geolocation g WHERE g.dtcreate = :dtcreate"),
    @NamedQuery(name = "Geolocation.findByIdusuario", query = "SELECT g FROM Geolocation g WHERE g.idusuario = :idusuario"),
    @NamedQuery(name = "Geolocation.findByAddress", query = "SELECT g FROM Geolocation g WHERE g.address = :address"),
    @NamedQuery(name = "Geolocation.findByMsg", query = "SELECT g FROM Geolocation g WHERE g.msg = :msg"),
    @NamedQuery(name = "Geolocation.findByLatitude", query = "SELECT g FROM Geolocation g WHERE g.latitude = :latitude"),
    @NamedQuery(name = "Geolocation.findByLongitude", query = "SELECT g FROM Geolocation g WHERE g.longitude = :longitude")})
@Getter
@Setter
public class Geolocation implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "idusuario")
    private long idusuario;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "msg")
    private String msg;
    @Basic(optional = false)
    @Column(name = "latitude")
    private float latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private float longitude;

    public Geolocation() {
    }

    public Geolocation(Long id) {
        this.id = id;
    }

    public Geolocation(Long id, Date dtcreate, long idusuario, String address, float latitude, float longitude) {
        this.id = id;
        this.dtcreate = dtcreate;
        this.idusuario = idusuario;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
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
        if (!(object instanceof Geolocation)) {
            return false;
        }
        Geolocation other = (Geolocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demos.vo.Geolocation[ id=" + id + " ]";
    }
    
}

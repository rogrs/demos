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
@Table(name = "AUTHENTICATION_CREDENTIALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthenticationCredentials.findAll", query = "SELECT a FROM AuthenticationCredentials a"),
    @NamedQuery(name = "AuthenticationCredentials.findById", query = "SELECT a FROM AuthenticationCredentials a WHERE a.id = :id"),
    @NamedQuery(name = "AuthenticationCredentials.findByUsername", query = "SELECT a FROM AuthenticationCredentials a WHERE a.username = :username"),
    @NamedQuery(name = "AuthenticationCredentials.findByPwd", query = "SELECT a FROM AuthenticationCredentials a WHERE a.pwd = :pwd"),
    @NamedQuery(name = "AuthenticationCredentials.findBySalt", query = "SELECT a FROM AuthenticationCredentials a WHERE a.salt = :salt"),
    @NamedQuery(name = "AuthenticationCredentials.findByFullname", query = "SELECT a FROM AuthenticationCredentials a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "AuthenticationCredentials.findByAuthorizationProfileId", query = "SELECT a FROM AuthenticationCredentials a WHERE a.authorizationProfileId = :authorizationProfileId"),
    @NamedQuery(name = "AuthenticationCredentials.findByDtcreate", query = "SELECT a FROM AuthenticationCredentials a WHERE a.dtcreate = :dtcreate"),
    @NamedQuery(name = "AuthenticationCredentials.findByEnable", query = "SELECT a FROM AuthenticationCredentials a WHERE a.enable = :enable")})
@Getter
@Setter
public class AuthenticationCredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "AUTHORIZATION_PROFILE_ID")
    private long authorizationProfileId;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Basic(optional = false)
    @Column(name = "enable")
    private int enable;

    public AuthenticationCredentials() {
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
        if (!(object instanceof AuthenticationCredentials)) {
            return false;
        }
        AuthenticationCredentials other = (AuthenticationCredentials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.demo.vo.AuthenticationCredentials[ id=" + id + " ]";
    }
    
}

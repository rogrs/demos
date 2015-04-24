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
@Table(name = "formulario")
@XmlRootElement
@Getter
@Setter
public class Formulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "estuda")
    private String estuda;
    @Column(name = "cumprimenta")
    private String cumprimenta;
    @Column(name = "domesticos")
    private String domesticos;
    @Column(name = "compra")
    private String  compra;
    @Column(name = "fuma")
    private String  fuma;
    @Column(name = "olhos")
    private String  olhos;
    @Column(name = "altura")
    private String  altura;
    @Column(name = "aparelho")
    private String  aparelho;
    @Column(name = "caros")
    private String caros;
    @Column(name = "crescer")
    private String crescer;
    @Column(name = "amigo")
    private String  amigo;
    @Column(name = "animal")
    private String animal;
    @Column(name = "pais")
    private String pais;
    @Column(name = "filme")
    private String filme;
    @Column(name = "tv")
    private String  tv;
    @Column(name = "livro")
    private String livro;
    @Column(name = "bebida")
    private String bebida;
    @Column(name = "loja")
    private String loja;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "rede")
    private String rede;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "filhos")
    private String filhos;
    @Column(name = "deus")
    private String deus;
    @Column(name = "youtube")
    private String youtube;
    @Column(name = "fazer")
    private String fazer;
    @Column(name = "assistiu")
    private String assistiu;
    @Column(name = "torcida")
    private String torcida;
    @Column(name = "oculos")
    private String oculos;
    @Column(name = "moram")
    private String moram;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;

    public Formulario() {
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
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}

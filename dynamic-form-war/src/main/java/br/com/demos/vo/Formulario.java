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
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f"),
    @NamedQuery(name = "Formulario.findById", query = "SELECT f FROM Formulario f WHERE f.id = :id"),
    @NamedQuery(name = "Formulario.findByNome", query = "SELECT f FROM Formulario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Formulario.findByEstuda", query = "SELECT f FROM Formulario f WHERE f.estuda = :estuda"),
    @NamedQuery(name = "Formulario.findByCumprimenta", query = "SELECT f FROM Formulario f WHERE f.cumprimenta = :cumprimenta"),
    @NamedQuery(name = "Formulario.findByDomesticos", query = "SELECT f FROM Formulario f WHERE f.domesticos = :domesticos"),
    @NamedQuery(name = "Formulario.findByCompra", query = "SELECT f FROM Formulario f WHERE f.compra = :compra"),
    @NamedQuery(name = "Formulario.findByFuma", query = "SELECT f FROM Formulario f WHERE f.fuma = :fuma"),
    @NamedQuery(name = "Formulario.findByOlhos", query = "SELECT f FROM Formulario f WHERE f.olhos = :olhos"),
    @NamedQuery(name = "Formulario.findByAltura", query = "SELECT f FROM Formulario f WHERE f.altura = :altura"),
    @NamedQuery(name = "Formulario.findByAparelho", query = "SELECT f FROM Formulario f WHERE f.aparelho = :aparelho"),
    @NamedQuery(name = "Formulario.findByCaros", query = "SELECT f FROM Formulario f WHERE f.caros = :caros"),
    @NamedQuery(name = "Formulario.findByCrescer", query = "SELECT f FROM Formulario f WHERE f.crescer = :crescer"),
    @NamedQuery(name = "Formulario.findByAmigo", query = "SELECT f FROM Formulario f WHERE f.amigo = :amigo"),
    @NamedQuery(name = "Formulario.findByAnimal", query = "SELECT f FROM Formulario f WHERE f.animal = :animal"),
    @NamedQuery(name = "Formulario.findByPais", query = "SELECT f FROM Formulario f WHERE f.pais = :pais"),
    @NamedQuery(name = "Formulario.findByFilme", query = "SELECT f FROM Formulario f WHERE f.filme = :filme"),
    @NamedQuery(name = "Formulario.findByTv", query = "SELECT f FROM Formulario f WHERE f.tv = :tv"),
    @NamedQuery(name = "Formulario.findByLivro", query = "SELECT f FROM Formulario f WHERE f.livro = :livro"),
    @NamedQuery(name = "Formulario.findByBebida", query = "SELECT f FROM Formulario f WHERE f.bebida = :bebida"),
    @NamedQuery(name = "Formulario.findByLoja", query = "SELECT f FROM Formulario f WHERE f.loja = :loja"),
    @NamedQuery(name = "Formulario.findByLugar", query = "SELECT f FROM Formulario f WHERE f.lugar = :lugar"),
    @NamedQuery(name = "Formulario.findByRede", query = "SELECT f FROM Formulario f WHERE f.rede = :rede"),
    @NamedQuery(name = "Formulario.findByModelo", query = "SELECT f FROM Formulario f WHERE f.modelo = :modelo"),
    @NamedQuery(name = "Formulario.findByFilhos", query = "SELECT f FROM Formulario f WHERE f.filhos = :filhos"),
    @NamedQuery(name = "Formulario.findByDeus", query = "SELECT f FROM Formulario f WHERE f.deus = :deus"),
    @NamedQuery(name = "Formulario.findByYoutube", query = "SELECT f FROM Formulario f WHERE f.youtube = :youtube"),
    @NamedQuery(name = "Formulario.findByFazer", query = "SELECT f FROM Formulario f WHERE f.fazer = :fazer"),
    @NamedQuery(name = "Formulario.findByAssistiu", query = "SELECT f FROM Formulario f WHERE f.assistiu = :assistiu"),
    @NamedQuery(name = "Formulario.findByTorcida", query = "SELECT f FROM Formulario f WHERE f.torcida = :torcida"),
    @NamedQuery(name = "Formulario.findByOculos", query = "SELECT f FROM Formulario f WHERE f.oculos = :oculos"),
    @NamedQuery(name = "Formulario.findByMoram", query = "SELECT f FROM Formulario f WHERE f.moram = :moram"),
    @NamedQuery(name = "Formulario.findByDtcreate", query = "SELECT f FROM Formulario f WHERE f.dtcreate = :dtcreate")})
@Getter
@Setter
public class Formulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "estuda")
    private String estuda;
    @Column(name = "cumprimenta")
    private String cumprimenta;
    @Column(name = "domesticos")
    private String domesticos;
    @Column(name = "compra")
    private String compra;
    @Column(name = "fuma")
    private String fuma;
    @Column(name = "olhos")
    private String olhos;
    @Column(name = "altura")
    private String altura;
    @Column(name = "aparelho")
    private String aparelho;
    @Column(name = "caros")
    private String caros;
    @Column(name = "crescer")
    private String crescer;
    @Column(name = "amigo")
    private String amigo;
    @Column(name = "animal")
    private String animal;
    @Column(name = "pais")
    private String pais;
    @Column(name = "filme")
    private String filme;
    @Column(name = "tv")
    private String tv;
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

    public Formulario(Long id) {
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
        return "br.com.demo.vo.Formulario[ id=" + id + " ]";
    }
    
}

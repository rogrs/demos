package br.com.demos.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tarefas")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tarefas.findAll", query = "SELECT t FROM Tarefas t"),
        @NamedQuery(name = "Tarefas.findById", query = "SELECT t FROM Tarefas t WHERE t.id = :id"),
        @NamedQuery(name = "Tarefas.findByTarefa", query = "SELECT t FROM Tarefas t WHERE t.tarefa = :tarefa"),
        @NamedQuery(name = "Tarefas.findByDtcreate", query = "SELECT t FROM Tarefas t WHERE t.dtcreate = :dtcreate"),
        @NamedQuery(name = "Tarefas.findByEnabled", query = "SELECT t FROM Tarefas t WHERE t.enabled = :enabled") })
@Getter
@Setter
public class Tarefas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "tarefa")
    private String tarefa;
    @Basic(optional = false)
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcreate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;

    public Tarefas() {
    }

    public Tarefas(String tarefa) {
        this.tarefa = tarefa;
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
        if (!(object instanceof Tarefas)) {
            return false;
        }
        Tarefas other = (Tarefas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tarefa;
    }

}

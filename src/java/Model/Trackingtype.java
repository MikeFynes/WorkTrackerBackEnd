/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mike
 */
@Entity
@Table(name = "trackingtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trackingtype.findAll", query = "SELECT t FROM Trackingtype t"),
    @NamedQuery(name = "Trackingtype.findById", query = "SELECT t FROM Trackingtype t WHERE t.id = :id"),
    @NamedQuery(name = "Trackingtype.findByName", query = "SELECT t FROM Trackingtype t WHERE t.name = :name"),
    @NamedQuery(name = "Trackingtype.findByDescription", query = "SELECT t FROM Trackingtype t WHERE t.description = :description"),
    @NamedQuery(name = "Trackingtype.sortById", query = "SELECT t FROM Trackingtype t ORDER BY t.id")})
public class Trackingtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 25)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "trackingtype")
    private Collection<Worktime> worktimeCollection;

    public Trackingtype() {
    }

    public Trackingtype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Worktime> getWorktimeCollection() {
        return worktimeCollection;
    }

    public void setWorktimeCollection(Collection<Worktime> worktimeCollection) {
        this.worktimeCollection = worktimeCollection;
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
        if (!(object instanceof Trackingtype)) {
            return false;
        }
        Trackingtype other = (Trackingtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Trackingtype[ id=" + id + " ]";
    }
    
}

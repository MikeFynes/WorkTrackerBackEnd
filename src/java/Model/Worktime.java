/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mike
 */
@Entity
@Table(name = "worktime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worktime.findAll", query = "SELECT w FROM Worktime w"),
    @NamedQuery(name = "Worktime.findById", query = "SELECT w FROM Worktime w WHERE w.id = :id"),
    
    @NamedQuery(name = "Worktime.findByStarttime", query = "SELECT w FROM Worktime w WHERE w.starttime = :starttime"),
    @NamedQuery(name = "Worktime.findByEndtime", query = "SELECT w FROM Worktime w WHERE w.endtime = :endtime"),
    @NamedQuery(name = "Worktime.findByEmployee", query = "SELECT w FROM Worktime w WHERE w.employee= :employee"),
    @NamedQuery(name = "Worktime.sortAscending", query ="SELECT w FROM Worktime w ORDER BY w.endtime DESC"),
    
})
public class Worktime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "STARTTIME")
    private BigInteger starttime;
    @Column(name = "ENDTIME")
    private BigInteger endtime;
    @JoinColumn(name = "TRACKINGTYPE", referencedColumnName = "ID")
    @ManyToOne
    private Trackingtype trackingtype;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;

    public Worktime() {
    }

    public Worktime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public BigInteger getStarttime() {
        return starttime;
    }

    public void setStarttime(BigInteger starttime) {
        this.starttime = starttime;
    }

    public BigInteger getEndtime() {
        return endtime;
    }

    public void setEndtime(BigInteger endtime) {
        this.endtime = endtime;
    }

    public Trackingtype getTrackingtype() {
        return trackingtype;
    }

    public void setTrackingtype(Trackingtype trackingtype) {
        this.trackingtype = trackingtype;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Worktime)) {
            return false;
        }
        Worktime other = (Worktime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Worktime[ id=" + id + " ]";
    }
    
}

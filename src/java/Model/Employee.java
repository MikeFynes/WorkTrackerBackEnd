/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByFname", query = "SELECT e FROM Employee e WHERE e.fname = :fname"),
    @NamedQuery(name = "Employee.findByLname", query = "SELECT e FROM Employee e WHERE e.lname = :lname"),
    @NamedQuery(name = "Employee.sortById", query = "SELECT e FROM Employee e ORDER BY e.id")})
public class Employee implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Codes> codesCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 25)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 25)
    @Column(name = "LNAME")
    private String lname;
    @JoinColumn(name = "ROLE", referencedColumnName = "ID")
    @ManyToOne
    private Permissionlevel role;
    @OneToMany(mappedBy = "supervisor")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "SUPERVISOR", referencedColumnName = "ID")
    @ManyToOne
    private Employee supervisor;
    @OneToMany(mappedBy = "employee")
    private Collection<Worktime> worktimeCollection;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Permissionlevel getRole() {
        return role;
    }

    public void setRole(Permissionlevel role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Employee[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Codes> getCodesCollection() {
        return codesCollection;
    }

    public void setCodesCollection(Collection<Codes> codesCollection) {
        this.codesCollection = codesCollection;
    }
    
}
